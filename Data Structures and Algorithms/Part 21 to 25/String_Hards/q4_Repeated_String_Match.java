package String_Hards;
/*686. Repeated String Match
Medium
Topics
Companies
Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".

 

Example 1:

Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
Example 2:

Input: a = "a", b = "aa"
Output: 2
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist of lowercase English letters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
204.6K
Submissions
559.1K
Acceptance Rate
36.6% */
public class q4_Repeated_String_Match {
    // //Very slow, but correct code, recommend as 1st try
    // public int repeatedStringMatch(String a, String b) {
    //     int minRepeats = (int)Math.ceil(b.length() / a.length());

    //     for (int i = 0; i <= minRepeats + 2; i++){
    //         String repeatA = a.repeat(i);
    //         if (repeatA.contains(b)) return i;
    //     }
    //     return -1;
    // }
    // //20% faster version of above
    // public int repeatedStringMatch(String a, String b) {
    //     int minRepeats = (int)Math.ceil(b.length() / a.length());
    //     StringBuilder repA = new StringBuilder(a);
    //     int cnt =1;
    //     for ( ; cnt < minRepeats; cnt++){
    //         repA.append(a);
    //     }
    //     if (repA.toString().contains(b)) return cnt;
    //     repA.append(a);
    //     if (repA.toString().contains(b)) return cnt+1;
    // }
    // //SImilar to above
    // public int repeatedStringMatch(String a, String b) {
    //     StringBuilder repA = new StringBuilder(a);
    //     int cnt =1;
    //     while(repA.length()<b.length()){
    //         cnt++;
    //         repA.append(a);
    //     }
    //     if (repA.toString().contains(b)) return cnt;
    //     repA.append(a);
    //     if (repA.toString().contains(b)) return cnt+1;
    //     return -1;
    // }
    
    private static final int MOD = 1000000; //any large no., just to prevent overflow, need not even be prime as we check when == hash anyway
    private static final int BASE = 31; //any prime no.
    public int repeatedStringMatch(String A, String B) {
        //if (A.equals(B)) return 1;

        int count = 1;
        StringBuilder source = new StringBuilder(A);

        // Repeat A until its length >= B
        while (source.length() < B.length()) {
            source.append(A);
            count++;
        }

        //if (source.toString().equals(B)) return count;

        if (rabinKarp(source.toString(), B) != -1) return count;

        source.append(A);
        if (rabinKarp(source.toString(), B) != -1) return count + 1;

        return -1;
    }

    private int rabinKarp(String source, String target) {
        //if (source == null || target == null || target.length() > source.length()) return -1;

        int m = target.length();
        int power = 1;

        // Compute BASE^m % MOD
        for (int i = 0; i < m; i++) {
            power = (power * BASE) % MOD;
        }

        // Compute hash of target
        int targetHash = 0;
        for (int i = 0; i < m; i++) {
            targetHash = (targetHash * BASE + target.charAt(i)) % MOD;
        }

        // Rolling hash
        int hash = 0;
        for (int i = 0; i < source.length(); i++) {
            hash = (hash * BASE + source.charAt(i)) % MOD;

            if (i >= m) {
                hash = (hash - source.charAt(i - m) * power) % MOD;
                if (hash < 0) hash += MOD;
            }

            if (i >= m - 1 && hash == targetHash) {
                String substring = source.substring(i - m + 1, i + 1);
                if (substring.equals(target)) {
                    return i - m + 1;
                }
            }
        }

        return -1;
    }
}


