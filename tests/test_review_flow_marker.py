import unittest
import pathlib


class ReviewFlowMarkerTest(unittest.TestCase):
    def test_review_flow_marker_file_exists_and_content(self):
        """Ensure review-flow-marker.md exists at repository root and has the expected content."""
        p = pathlib.Path("review-flow-marker.md")
        self.assertTrue(p.exists(), "review-flow-marker.md should exist")
        content = p.read_text(encoding="utf-8").strip()
        expected = "# Review Flow Marker\n\n<!-- E2E test marker -->"
        self.assertEqual(content, expected, f"Unexpected content: {content!r}")


if __name__ == "__main__":
    unittest.main()
