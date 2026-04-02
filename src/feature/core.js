let _initializedInstance = null;
let _isShutdown = false;
const ALLOWED_MODES = ['test', 'prod'];

async function initializeFeature(config = {}) {
  // validate config.mode
  const mode = config.mode === undefined ? 'test' : config.mode;
  if (!ALLOWED_MODES.includes(mode)) {
    throw new Error(`Unknown mode: ${mode}`);
  }

  _isShutdown = false;
  const instance = {
    async process(item) {
      if (_isShutdown) throw new Error('Feature is shutdown');
      // validate item shape
      if (!item || typeof item !== 'object' || Array.isArray(item)) {
        throw new Error('Invalid item');
      }
      // minimal processing: return the item with a marker
      return { ...item, processed: true };
    },
    async shutdown() {
      _isShutdown = true;
    }
  };
  _initializedInstance = instance;
  return instance;
}

async function processItem(item) {
  if (!_initializedInstance || _isShutdown) {
    throw new Error('Feature not initialized');
  }
  return _initializedInstance.process(item);
}

async function shutdownFeature() {
  _isShutdown = true;
  if (_initializedInstance && typeof _initializedInstance.shutdown === 'function') {
    await _initializedInstance.shutdown();
  }
  _initializedInstance = null;
}

module.exports = { initializeFeature, processItem, shutdownFeature };
