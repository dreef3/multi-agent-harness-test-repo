def test_review_flow_marker_file_exists_and_content():
    """Ensure review-flow-marker.md exists at repository root and has the expected content."""
    import pathlib

    p = pathlib.Path("review-flow-marker.md")
    assert p.exists(), "review-flow-marker.md should exist"
    content = p.read_text(encoding="utf-8").strip()
    assert content == "# Review Flow Marker", f"Unexpected content: {content!r}"
