#!/bin/sh
set -eu
path="review-flow-marker.md"
if [ ! -f "$path" ]; then
  echo "MISSING: $path"
  exit 2
fi
# read file content as-is
content=$(cat -- "$path")
expected="# Review Flow Marker\n"
# Compare raw bytes: append a marker to show newline
if [ "$content" = "# Review Flow Marker" ]; then
  echo "TEST FAIL: file missing trailing newline"
  exit 1
elif [ "$content" = "# Review Flow Marker\n" ]; then
  echo "TEST PASS"
  exit 0
else
  echo "TEST FAIL: unexpected content:"
  printf '%s' "$content"
  echo
  exit 1
fi
