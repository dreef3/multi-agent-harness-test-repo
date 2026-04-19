#!/bin/sh
set -eu
path="review-flow-marker.md"
if [ ! -f "$path" ]; then
  echo "MISSING: $path"
  exit 2
fi
# Check last byte of file. If it's ASCII 10 (newline), test passes.
last_byte=$(tail -c1 -- "$path" | od -An -t u1 | tr -d ' ')
if [ -z "$last_byte" ]; then
  # empty output means file is empty or tail failed
  echo "TEST FAIL: cannot read last byte"
  exit 1
fi
if [ "$last_byte" -eq 10 ]; then
  echo "TEST PASS"
  exit 0
else
  echo "TEST FAIL: file missing trailing newline (last byte code: $last_byte)"
  exit 1
fi
