const path = require('path');
const { initializeFeature, processItem, shutdownFeature } = require(path.resolve(__dirname, '../../../src/feature/core'));


describe('feature core API', () => {
  test('exports the API functions', () => {
    expect(typeof initializeFeature).toBe('function');
    expect(typeof processItem).toBe('function');
    expect(typeof shutdownFeature).toBe('function');
  });

  test('initializeFeature returns an instance object with process and shutdown', async () => {
    const instance = await initializeFeature({ mode: 'test' });
    expect(instance).toBeDefined();
    expect(typeof instance.process).toBe('function');
    expect(typeof instance.shutdown).toBe('function');
  });

  test('processItem throws when called before initialize', async () => {
    // Ensure shutdown to simulate uninitialized state
    await shutdownFeature();
    await expect(processItem({ id: 1 })).rejects.toThrow();
  });
});
