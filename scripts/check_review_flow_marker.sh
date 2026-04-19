#!/usr/bin/env bash
set -euo pipefail
file="review-flow-marker.md"
if [ ! -f "$file" ]; then
  echo "Missing $file"
  exit 2
fi
last_line=$(tail -n 1 "$file" | tr -d '\r')
if [ "$last_line" = "<!-- E2E test marker -->" ]; then
  echo "OK"
  exit 0
else
  echo "FAIL: last line is '$last_line'"
  exit 1
fi
