#!/usr/bin/env python3
import sys

path = 'review-flow-marker.md'
try:
    with open(path, 'r', encoding='utf-8') as f:
        data = f.read()
except FileNotFoundError:
    print('FAIL: file not found')
    sys.exit(2)

expected = "# Review Flow Marker\n"
if data == expected:
    print('PASS')
    sys.exit(0)
else:
    print('FAIL: content mismatch')
    print('Expected:')
    print(repr(expected))
    print('Got:')
    print(repr(data))
    sys.exit(1)
