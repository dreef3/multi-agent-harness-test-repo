def test_review_flow_marker_has_expected_content():
    """Failing test: file should contain a trailing newline."
    path = "review-flow-marker.md"
    with open(path, "r", encoding="utf-8") as f:
        content = f.read()
    assert content == "# Review Flow Marker\n", (
        f"Expected exact content '# Review Flow Marker\\n' but got: {repr(content)}"
    )
