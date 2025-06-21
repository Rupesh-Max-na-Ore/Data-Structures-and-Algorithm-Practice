package Strings_Basic_and_Medium.Medium_String_Problems;
/*Q1
 * 
Code
Testcase
Testcase
Test Result
451. Sort Characters By Frequency
Solved
Medium
Topics
Companies
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
737.7K
Submissions
1M
Acceptance Rate
72.6%
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SortByFrequency {

    public String frequencySort(String s) {
        HashMap<Character, Integer> FREQ = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (!FREQ.containsKey(c)) {
                FREQ.put(c, 0);
            }
            FREQ.put(c, FREQ.get(c) + 1);
            max = Math.max(max, FREQ.get(c));
        }
        HashMap<Integer, Queue<Character>> freqToCharList = new HashMap<>();
        for (Character c:FREQ.keySet()) {
            int cnt = FREQ.get(c);
            if (!freqToCharList.containsKey(cnt)) {
                freqToCharList.put(cnt, new LinkedList<Character>());
            }
            freqToCharList.get(cnt).add(c);
        }
        StringBuilder SortedAns = new StringBuilder();
        for (int i = max; i > 0; i --) {
            if (freqToCharList.containsKey(i)) {
                while (!freqToCharList.get(i).isEmpty()) {
                    char c = freqToCharList.get(i).poll();
                    for (int j = 0; j < i; j ++) {
                        SortedAns.append(c);
                    }    
                }
            }

        }
        return SortedAns.toString();
    }

    public String frequencySort2(String s){
    final int n = s.length();
    StringBuilder SortedAns = new StringBuilder();
    int[] Freq = new int[128];
    // buckets[i] = characters that appear 'i' times in s
    List<Character>[] buckets = new List[n + 1];

    for (final char c : s.toCharArray())
      ++Freq[c];

    for (int i = 0; i < 128; ++i) {
      final int freq = Freq[i];
      if (freq > 0) {
        if (buckets[freq] == null)
        {
            buckets[freq] = new ArrayList<>();
        }
        buckets[freq].add((char) i);
      }
    }

    for (int freq = n; freq > 0; --freq)
      {
        if (buckets[freq] != null)
        {
            for (final char c : buckets[freq])
          {
            for (int i = 0; i < freq; ++i)
            SortedAns.append(c);
            }
        }
    }

    return SortedAns.toString();
    }
}

// //lc submission, use max to reduce time taken by small cases
// class Solution {
//     public String frequencySort(String s) {
// final int n = s.length();
//     StringBuilder SortedAns = new StringBuilder();
//     int[] Freq = new int[128];
//     // buckets[i] = characters that appear 'i' times in s
//     List<Character>[] buckets = new List[n + 1];
//     int max=0;
//     for (final char c : s.toCharArray())
//      { ++Freq[c];
//         max=(Freq[c]>max)? Freq[c]:max;
//      }

//     for (int i = 0; i < 128; ++i) {
//       final int freq = Freq[i];
//       if (freq > 0) {
//         if (buckets[freq] == null)
//         {
//             buckets[freq] = new ArrayList<>();
//         }
//         buckets[freq].add((char) i);
//       }
//     }

//     for (int freq = max; freq > 0; --freq)
//       {
//         if (buckets[freq] != null)
//         {
//             for (final char c : buckets[freq])
//           {
//             for (int i = 0; i < freq; ++i)
//             SortedAns.append(c);
//             }
//         }
//     }

//     return SortedAns.toString();
//     }
// }