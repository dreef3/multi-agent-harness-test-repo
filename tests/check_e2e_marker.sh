#!/usr/bin/env bash
set -euo pipefail

FILE="e2e-marker.md"
EXPECTED="# E2E Test Passed"

if [ ! -f "$FILE" ]; then
  echo "FAIL: $FILE does not exist"
  exit 1
fi

CONTENT=$(cat "$FILE")
if [ "$CONTENT" != "$EXPECTED" ]; then
  echo "FAIL: $FILE content incorrect"
  echo "Expected: $EXPECTED"
  echo "Got: $CONTENT"
  exit 1
fi

echo "PASS: $FILE exists and content matches"
exit 0
