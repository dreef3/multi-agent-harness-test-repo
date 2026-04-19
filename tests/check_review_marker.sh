#!/usr/bin/env bash
set -euo pipefail

EXPECTED="# Review Flow Marker"
FILE="review-flow-marker.md"

if [ ! -f "$FILE" ]; then
  echo "FAIL: $FILE does not exist"
  exit 1
fi

ACTUAL=$(cat "$FILE" )
if [ "$ACTUAL" != "$EXPECTED" ]; then
  echo "FAIL: $FILE content mismatch"
  echo "Expected: '$EXPECTED'"
  echo "Actual:   '$ACTUAL'"
  exit 2
fi

echo "PASS: $FILE exists and content matches"
exit 0
