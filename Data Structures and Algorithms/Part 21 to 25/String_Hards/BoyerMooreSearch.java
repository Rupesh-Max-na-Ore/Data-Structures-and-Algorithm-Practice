import java.text.Normalizer;
import java.util.*;

public class BoyerMooreSearch {

    public static int boyerMoore(String text, String pattern) {
        text = Normalizer.normalize(text, Normalizer.Form.NFC);
        pattern = Normalizer.normalize(pattern, Normalizer.Form.NFC);
        
        int n = text.length();
        int m = pattern.length();
        if (m == 0) return 0;
        if (n < m) return -1;

        Map<Character, Integer> badCharShift = computeBadCharacterRule(pattern);
        int[] goodSuffixShift = computeGoodSuffixRule(pattern);

        int t = 0;

        while (t <= n - m) {
            int j = m - 1;

            while (j >= 0 && pattern.charAt(j) == text.charAt(t + j)) {
                j--;
            }

            if (j == -1) {
                return t;
            } else {
                char mismatchChar = text.charAt(t + j);
                int lastOcc = badCharShift.getOrDefault(mismatchChar, -1);
                int shiftBy = Math.max(j - lastOcc, goodSuffixShift[j]);
                t += shiftBy;
            }
        }

        return -1;
    }

    private static Map<Character, Integer> computeBadCharacterRule(String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), i);
        }
        return map;
    }

    private static int[] computeGoodSuffixRule(String pattern) {
        int m = pattern.length();
        int[] shift = new int[m];
        int[] border = new int[m + 1];

        int i = m;
        int j = m + 1;
        border[i] = j;

        while (i > 0) {
            while (j <= m && pattern.charAt(i - 1) != pattern.charAt(j - 1)) {
                if (j <= m && shift[j - 1] == 0) {
                    shift[j - 1] = j - i;
                }
                j = border[j];
            }
            i--;
            j--;
            border[i] = j;
        }

        int b = border[0];
        for (i = 0; i < m; i++) {
            if (shift[i] == 0) {
                shift[i] = b;
            }
            if (i == b) {
                b = border[b];
            }
        }

        return shift;
    }

    // TEST CASES
    public static void runTests() {
        class TestCase {
            String text, pattern;
            int expected;

            TestCase(String text, String pattern, int expected) {
                this.text = text;
                this.pattern = pattern;
                this.expected = expected;
            }
        }

        List<TestCase> testCases = Arrays.asList(
            new TestCase("abcdefg", "cde", 2),
            new TestCase("hello world", "world", 6),
            new TestCase("banana", "apple", -1),
            new TestCase("mississippi", "issi", 1),
            new TestCase("foobarbaz", "bar", 3),
            new TestCase("abcabcabc", "abc", 0),
            new TestCase("abcdefgh", "abcdefgh", 0),
            new TestCase("xyz", "xyz", 0),
            new TestCase("foo", "foo", 0),
            new TestCase("bar", "baz", -1),
            new TestCase("a", "a", 0),
            new TestCase("", "pattern", -1),
            new TestCase("pattern", "", 0),
            new TestCase("abcabcabc", "bcd", -1),
            new TestCase("aabbaabbaabbaabb", "aabbaabb", 0),
            new TestCase("aabbaabbaabbaabb", "bb", 2),
            new TestCase("aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyyzz", "xxyy", 46),
            new TestCase("aaaabbaaaaaababaaabaaa", "aaa", 0),
            new TestCase("abcdefghijklmnopqrstuvwxyz", "xyz", 23),
            new TestCase("GTTATAGCTGATCGCGCCGTAGCGGCGAA", "GTAGCGGCG", 18)
            );

        for (TestCase tc : testCases) {
            int result = boyerMoore(tc.text, tc.pattern);
            if (result != tc.expected) {
                System.out.printf("❌ FAILED for \"%s\" vs \"%s\" | Expected: %d, Got: %d\n", tc.text, tc.pattern, tc.expected, result);
            } else {
                System.out.printf("✅ PASSED for \"%s\" vs \"%s\" | Index: %d\n", tc.text, tc.pattern, result);
            }
        }

        // Unicode test
        String unicodeText = "내가 가진 건 이 노래 한방";
        String koreanPattern = "진"; // should match at index 4
        System.out.println("Unicode Match Index: " + boyerMoore(unicodeText, koreanPattern));
    }

    public static void main(String[] args) {
        runTests();
    }
}
/* */