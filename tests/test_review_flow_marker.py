def test_review_flow_marker_file_exists_and_content():
    path = "review-flow-marker.md"
    with open(path, "r", encoding="utf-8") as f:
        content = f.read()
    assert content.strip() == "# Review Flow Marker"