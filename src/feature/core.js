let _initializedInstance = null;
let _isShutdown = false;

async function initializeFeature(config) {
  // minimal initialization: store instance with process and shutdown methods
  _isShutdown = false;
  const instance = {
    async process(item) {
      if (_isShutdown) throw new Error('Feature is shutdown');
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
