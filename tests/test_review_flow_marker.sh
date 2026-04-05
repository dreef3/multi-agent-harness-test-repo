#!/usr/bin/env bash
set -euo pipefail

file=review-flow-marker.md
expected="# Review Flow Marker"

if [[ ! -f "$file" ]]; then
  echo "FAIL: $file does not exist"
  exit 1
fi

# Read file content (strip trailing newline)
content=$(printf "%s" "$(cat "$file")")

if [[ "$content" != "$expected" ]]; then
  echo "FAIL: content mismatch"
  echo "Expected: '$expected'"
  echo "Got:      '$content'"
  exit 1
fi

echo "OK"
