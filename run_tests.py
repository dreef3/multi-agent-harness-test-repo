import glob
import importlib.util
import sys
import traceback

failed = False

for path in glob.glob('tests/test_*.py'):
    spec = importlib.util.spec_from_file_location('test_module', path)
    mod = importlib.util.module_from_spec(spec)
    try:
        spec.loader.exec_module(mod)
    except Exception:
        print(f"ERROR importing {path}:")
        traceback.print_exc()
        failed = True
        continue
    for name in dir(mod):
        if name.startswith('test_'):
            fn = getattr(mod, name)
            try:
                fn()
                print(f"PASS: {path}::{name}")
            except AssertionError:
                print(f"FAIL: {path}::{name}")
                traceback.print_exc()
                failed = True
            except Exception:
                print(f"ERROR running {path}::{name}")
                traceback.print_exc()
                failed = True

if failed:
    sys.exit(1)
else:
    print("All tests passed")
