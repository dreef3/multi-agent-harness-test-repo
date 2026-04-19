def test_review_flow_marker_exists():
    path = "review-flow-marker.md"
    with open(path, "r", encoding="utf-8") as f:
        lines = f.read().splitlines()
    assert lines and lines[-1] == "<!-- E2E test marker -->", \
        f"Expected last line of {path} to be '<!-- E2E test marker -->', got: {lines[-1] if lines else 'EMPTY'}"
