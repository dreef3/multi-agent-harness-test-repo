const path = require('path');
const { initializeFeature, processItem, shutdownFeature } = require(path.resolve(__dirname, '../../../src/feature/core'));

describe('feature core edge cases', () => {
  afterEach(async () => {
    // ensure clean state between tests
    try {
      await shutdownFeature();
    } catch (e) {
      // ignore
    }
  });

  test('processItem rejects invalid item shape', async () => {
    await initializeFeature({ mode: 'test' });
    await expect(processItem(null)).rejects.toThrow(/invalid/i);
    await expect(processItem(123)).rejects.toThrow(/invalid/i);
    await expect(processItem([1,2,3])).rejects.toThrow(/invalid/i);
  });

  test('initializeFeature rejects unknown config', async () => {
    await expect(initializeFeature({ mode: 'unknown_mode' })).rejects.toThrow(/unknown/i);
  });

  test('initializeFeature accepts missing config and uses default mode', async () => {
    const instance = await initializeFeature();
    expect(instance).toBeDefined();
    const result = await processItem({ id: 'a' });
    expect(result).toEqual(expect.objectContaining({ id: 'a', processed: true }));
  });

  test('processItem handles concurrent items deterministically', async () => {
    await initializeFeature({ mode: 'test' });
    const items = [{id:1},{id:2},{id:3}];
    const results = await Promise.all(items.map(it => processItem(it)));
    expect(results).toHaveLength(3);
    for (let i = 0; i < items.length; i++) {
      expect(results[i]).toEqual(expect.objectContaining({ id: items[i].id, processed: true }));
    }
  });
});
