#!/usr/bin/env bash
set -euo pipefail
file=review-flow-marker.md
expected="# Review Flow Marker"
if [[ ! -f $file ]]; then
  echo "FAIL: $file does not exist"
  exit 1
fi
actual=$(sed -n '1p' "$file" | tr -d '\r')
if [[ "$actual" != "$expected" ]]; then
  echo "FAIL: content mismatch"
  echo "Expected: $expected"
  echo "Actual:   $actual"
  exit 1
fi

echo "PASS: $file contains expected content"
