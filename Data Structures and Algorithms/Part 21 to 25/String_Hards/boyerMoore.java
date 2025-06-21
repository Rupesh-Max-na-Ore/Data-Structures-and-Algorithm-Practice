import java.util.Arrays;

public class boyerMoore {
    private static int[] computeGoodSuffixRule(String pattern) {
    int m = pattern.length();
    int[] shift = new int[m];
    int[] border = new int[m + 1];

    int i = m;
    int j = m + 1;
    border[i] = j;

    System.out.println("\n=== Phase 1: Compute border positions ===");

    while (i > 0) {
        System.out.printf("Comparing pattern[%d] = %c and pattern[%d] = %c\n",
            i - 1, pattern.charAt(i - 1), j - 1, (j - 1 < m ? pattern.charAt(j - 1) : '#'));

        while (j <= m && pattern.charAt(i - 1) != pattern.charAt(j - 1)) {
            System.out.printf("  Mismatch: pattern[%d] != pattern[%d], ", i - 1, j - 1);

            if (j - 1 >= 0 && shift[j - 1] == 0) {
                shift[j - 1] = j - i;
                System.out.printf("setting shift[%d] = %d\n", j - 1, j - i);
            } else {
                System.out.println("shift already set");
            }

            System.out.printf("  border[%d] = %d → j = %d\n", j, border[j], border[j]);
            j = border[j];
        }

        i--;
        j--;
        border[i] = j;

        System.out.printf("Set border[%d] = %d\n", i, j);
    }

    System.out.println("\nIntermediate shift array after border mismatches:");
    System.out.println("shift = " + Arrays.toString(shift));
    System.out.println("border = " + Arrays.toString(border));

    System.out.println("\n=== Phase 2: Final shift propagation ===");

    int b = border[0];
    for (i = 0; i < m; i++) {
        if (shift[i] == 0) {
            shift[i] = b;
            System.out.printf("shift[%d] not set → set to border[0] = %d\n", i, b);
        } else {
            System.out.printf("shift[%d] already set = %d\n", i, shift[i]);
        }

        if (i == b) {
            b = border[b];
            System.out.printf("Reached border at i = %d → update b = border[%d] = %d\n", i, b, border[b]);
        }
    }

    System.out.println("\n=== Final Good Suffix Shift Table ===");
    System.out.println("shift = " + Arrays.toString(shift));

    return shift;
}
public static void main(String[] args) {
    // String pattern = "ABCDABD";  // Try variations: "ABCDABC", "ABAB", "ANPANMAN"
    // computeGoodSuffixRule(pattern);
    String txt = "GTTATAGCTGATCGCGCCGTAGCGGCGAA";
    String pat = "GTAGCGGCG";
    computeGoodSuffixRule(pat);
}

}
// Boyer-Moore substring search using both bad-character and good-suffix heuristics explained

// The rising star
// 4064
// Jul 20, 2020
// Java
// This problem may not really be asking for advanced substring search algorithms like KMP and Boyer-Moore etc, but it certainly provides scope for exploring them and testing their implementations here.

// I was able to understand Rabin Karp and KMP algorithms relatively easily but had a very hard time understanding the dynamics and implementation of Boyer-Moore algorithm.
// It is important because it is an efficient string-searching algorithm that is the standard benchmark for practical string-search literature. Many real life file system searches are implemented using this (eg: used in GNU's grep)

// The Boyer-Moore algorithm uses two different heuristics for determining the maximum possible shift distance in case of a mismatch: the "bad character" and the "good suffix" heuristics.
// The preprocessing for the good suffix heuristics is rather difficult to understand and to implement. Therefore, sometimes versions of the Boyer-Moore algorithm are found in which the good suffix heuristics is left away. The argument is that the bad character heuristics would be sufficient and the good suffix heuristics would not save many comparisons. However, this is not true for small alphabets.

// If for simplicity one wants to restrict oneself to the bad character heuristics, the Horspool algorithm or the Sunday algorithm are suited better.

// Because of very rare references available for implementation of complete algorithm, I would like to explain java implementation.
// As a beginner, I personlly found this video very helpful to grasp the overall working of the algorithm. Part 2 of video is here

// Understanding code directly could still be difficult. So you could better first try to understand the implementational details from this webpage.
// Refer this wonderful SO answer for more detailed explaination on good-suffix preprocessing code.

// Finally here goes the most awaited yet apparently frightening code:

// //Boyer-Moore substring search using both bad-character and good-suffix heuristics simultaneously
// 	public int strStr(String haystack, String needle) {
// 		if (haystack == null || needle == null || haystack.length() < needle.length()) {
// 			return -1;
// 		} else if (needle.isEmpty()) {
// 			return 0;
// 		}
		
// 		char[] text = haystack.toCharArray();
// 		char[] pattern = needle.toCharArray();
		
// 		int[] borderPosition = new int[pattern.length+1]; /* referred as f in academic literatures;
// 		f[i] contains the starting position of the widest border of the suffix of the pattern beginning at position i */
// 		int[] shift = new int[pattern.length+1]; /* referred as s in academic literatures; 
// 		Each entry s[i] contains the shift distance of the pattern if a mismatch at position i – 1 occurs, 
// 		i.e. if the suffix of the pattern starting at position i has matched */
// 		int alphabetSize = 256;
		
// 		int[] lastOccurence = preprocessBadCharacters(pattern, alphabetSize); // bad characters heuristic
// 		preprocessStrongSuffix(pattern, borderPosition, shift); //good suffix heuristic case 1
// 		preprocessPartialSuffix(borderPosition, shift, pattern.length); //good suffix heuristic case 2
// 		// good-suffix reference: https://stackoverflow.com/questions/19345263/boyer-moore-good-suffix-heuristics
		
// 		int i=0, j; // i is start index of current window in text 
// 		while(i<=text.length-pattern.length) {
// 			j = pattern.length-1; // we process pattern from right to left backwards
// 			while(j>=0 && pattern[j]==text[i+j]) { // go left backwards till characters are matching in current window
// 				j--;
// 			}
// 			if(j<0) { // will be true only when there was a complete match found for pattern in text
// 				return i; //report match found
// 				//use i=i+shift[0] if we want to find starting indices for all multiple matches
// 			} else { // mismatch found in current window comparison
// 				/*  After a mismatch the pattern is shifted by the maximum of the values 
// 				    given by the good-suffix and the bad-character heuristics */
// 				i = i + Math.max(shift[j+1], j-lastOccurence[text[i+j]]);
// 			}
// 		}
		
// 		return -1;
// 	}
	
// 	public int[] preprocessBadCharacters(char[] pattern, int alphabetSize) {
// 		int[] lastOccurence = new int[alphabetSize]; //contains last occurrence index of each character in pattern
// 		Arrays.fill(lastOccurence, -1);

// 		for (int i = 0; i < pattern.length; i++) {
// 			lastOccurence[pattern[i]] = i;
// 		}

// 		return lastOccurence;
// 	}
	
// 	public int[] preprocessStrongSuffix(char[] pattern, int[] borderPosition, int[] shift) {
// 		int m = pattern.length;
		
// 		int i = m, j = m + 1;
// 		borderPosition[i] = j; // The suffix ε beginning at position m has no border, therefore f[m] is set to m+1
// 		while (i > 0) {
// 			/* at this line, we know f[i], f[i+1], ... f[m]; If character at position i-1 is not  
//                equal to character at j-1, then continue searching to right of the pattern for border */
// 			while (j <= m && pattern[i - 1] != pattern[j - 1]) {
// 				/* the character preceding the occurrence of t in pattern P is different than the mismatching  
// 	               character in P, we stop skipping the occurrences and shift the pattern from i to j */
// 				if (shift[j] == 0) {
// 					shift[j] = j - i;
// 				}
// 				j = borderPosition[j]; // get the start position of the border of suffix pattern[j] ... pattern[m-1]
// 			}
			
// 			// pattern[i-1] matched with pattern[j-1], border is found. store the beginning position of border 
// 			i--;
// 			j--;
// 			borderPosition[i] = j;
// 		}
// 		return shift;
// 	}
	
// 	public void preprocessPartialSuffix(int[] borderPosition, int[] shift, int m) {
// 		int i, j;
// 		j = borderPosition[0];
// 		for (i = 0; i <= m; i++) {
// 			/* set the border position of the first character of the pattern to all indices 
// 			   in array shift having shift[i] = 0 */
// 			if (shift[i] == 0) {
// 				shift[i] = j;
// 			}
			
// 			/* suffix becomes shorter than borderPosition[0], use the position of next widest border as value of j */
// 			if (i == j) {
// 				j = borderPosition[j];
// 			}
// 		}
// 	}
// The Boyer–Moore algorithm as presented in the original paper has worst-case running time of O(n+m) only if the pattern does not appear in the text. When the pattern does occur in the text, running time of the original algorithm is O(nm) in the worst case.
// If the alphabet is large compared to the length of the pattern, the algorithm performs O(n/m) comparisons on the average. So Boyer-Moore algorithm is extremely fast on large texts (relative to the length of the pattern)
// For the very shortest patterns, the naive algorithm may be better.

// Any suggestions/feedbacks/improvements are welcome.

// Happy searching!

// Next
// Find the Index of the First Occurrence in a String
// Comments (1)

// Sort by:Best
// Type comment here...
// Comment

// Wexengos
// Sep 09, 2021
// Amazing, friend. You've helped me A LOT in Data Structure II at college! Hahaha

// However, you missed the
// "for(int i=0; i<m+1; i++) shift[i]=0;"
// after the declaration of Shift. In that case, it will have a memory dump at all shift positions, and thus not be able to do the search.

// Great post, nonetheless. Thanks a lot!

// 0
// Reply

