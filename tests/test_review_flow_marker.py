import os


def test_review_flow_marker_exists_and_content():
    path = "review-flow-marker.md"
    assert os.path.exists(path), f"{path} should exist"
    with open(path, "r", encoding="utf-8") as f:
        content = f.read()
    assert content.strip() == "# Review Flow Marker\n\n<!-- E2E test marker -->"
