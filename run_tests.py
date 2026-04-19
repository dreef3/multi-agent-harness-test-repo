import importlib.util
import sys
import traceback


def run_tests():
    tests = ["tests/test_review_flow_marker.py"]
    failures = 0
    for t in tests:
        spec = importlib.util.spec_from_file_location("test_module", t)
        mod = importlib.util.module_from_spec(spec)
        try:
            spec.loader.exec_module(mod)
        except Exception as e:
            print(f"ERROR importing {t}:")
            traceback.print_exc()
            failures += 1
            continue
        for name in dir(mod):
            if name.startswith("test_") and callable(getattr(mod, name)):
                try:
                    getattr(mod, name)()
                    print(f"PASS {t}::{name}")
                except AssertionError:
                    print(f"FAIL {t}::{name} (AssertionError)")
                    traceback.print_exc()
                    failures += 1
                except Exception:
                    print(f"ERROR {t}::{name}")
                    traceback.print_exc()
                    failures += 1
    return failures


if __name__ == '__main__':
    failures = run_tests()
    if failures:
        print(f"FAILED: {failures} test(s) failed")
        sys.exit(1)
    else:
        print("ALL TESTS PASSED")
        sys.exit(0)
