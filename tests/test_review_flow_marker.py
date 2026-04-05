import unittest
import pathlib


class ReviewFlowMarkerTest(unittest.TestCase):
    def test_exists_and_content(self):
        path = pathlib.Path("review-flow-marker.md")
        self.assertTrue(path.exists(), "review-flow-marker.md must exist")
        text = path.read_text(encoding="utf8").strip()
        self.assertEqual(text, "# Review Flow Marker")


if __name__ == "__main__":
    unittest.main()
