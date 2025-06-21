package Strings_Basic_and_Medium.Medium_String_Problems;

import java.util.TreeMap;

//Q7
/*
 * 1781. Sum of Beauty of All Substrings
Medium
Topics
Companies
Hint
The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.

 

Example 1:

Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
Example 2:

Input: s = "aabcbaa"
Output: 17
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
49.3K
Submissions
75.6K
Acceptance Rate
65.2%
 */
public class BeautyOfString {


    // MultiSet Soln., better for Integers
    // public int beautySum(String s) {
    //     int sum = 0;  // This variable will hold the sum of beauty values of all substrings.
    //     int length = s.length();  // Get the length of the input string s.
        
    //     // Loop over each character in the string to start a new substring
    //     for (int i = 0; i < length; i++) {
    //         int[] counts = new int[26];  // This array keeps track of the frequency of each character in the current substring.
    //         TreeMap<Integer, Integer> map = new TreeMap<>();  // This map keeps track of the frequencies of frequencies (meta-frequency).
            
    //         // Loop over each character starting from i to form substrings
    //         for (int j = i; j < length; j++) {
    //             char c = s.charAt(j);  // Get the current character.
    //             int index = c - 'a';  // Convert the character to an index (0 for 'a', 1 for 'b', etc.).
    //             counts[index]++;  // Increment the frequency of the current character.
    //             int count = counts[index];  // Get the new frequency of the current character.
                
    //             // Update the TreeMap with the new frequency
    //             map.put(count, map.getOrDefault(count, 0) + 1);  // Increment the count of the current frequency in the TreeMap.
                
    //             // Decrement the count of the previous frequency in the TreeMap
    //             if (map.containsKey(count - 1)) {  // Check if the previous frequency exists in the TreeMap.
    //                 map.put(count - 1, map.get(count - 1) - 1);  // Decrement its count.
    //                 if (map.get(count - 1) == 0)  // If the count of the previous frequency becomes zero, remove it from the TreeMap.
    //                     map.remove(count - 1);
    //             }
                
    //             // Get the highest frequency and lowest frequency in the current substring
    //             int maxFreq = map.lastKey();  // Get the highest frequency in the TreeMap.
    //             int minFreq = map.firstKey();  // Get the lowest frequency in the TreeMap.
                
    //             // Calculate the beauty of the current substring and add it to the sum
    //             sum += maxFreq - minFreq;  // The beauty is the difference between the highest and lowest frequencies.
    //         }
    //     }
        
    //     return sum;  // Return the total sum of beauties of all substrings.
    // }
        // Array soln., better fpr limited range of strings
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        // Iterate over all possible substrings
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; // Array to store frequency of each character in the substring
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                sum += calculateBeauty(freq);
            }
        }

        return sum;
    }

    private int calculateBeauty(int[] freq) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        // Find the max and min freq among chars that have non-zero freq
        for (int count : freq) {
            if (count > 0) {
                if (count > max) max = count;
                if (count < min) min = count;
            }
        }

        return max - min;
    }
    public static void main(String[] args) {
        BeautyOfString obj = new BeautyOfString();

        // Test cases
        String s1 = "aabcb";
        System.out.println("Sum of beauty for \"" + s1 + "\": " + obj.beautySum(s1)); // Output: 5

        String s2 = "aabcbaa";
        System.out.println("Sum of beauty for \"" + s2 + "\": " + obj.beautySum(s2)); // Output: 17
    }

    
}
// 2nd attempt, works
// public int beautySum(String s) {
    //     int n = s.length();
    //     int sum = 0;

    //     // Iterate over all possible substrings
    //     for (int i = 0; i < n; i++) {
    //         int[] freq = new int[26]; // Array to store frequency of each character in the substring
    //         for (int j = i; j < n; j++) {
    //             freq[s.charAt(j) - 'a']++;
    //             sum += calculateBeauty(freq);
    //         }
    //     }

    //     return sum;
    // }

    // private int calculateBeauty(int[] freq) {
    //     int max = 0;
    //     int min = Integer.MAX_VALUE;

    //     // Find the max and min freq among chars that have non-zero freq
    //     for (int count : freq) {
    //         if (count > 0) {
    //             if (count > max) max = count;
    //             if (count < min) min = count;
    //         }
    //     }

    //     return max - min;
    // }

    // // First attempt, not work, some errors
    // public int beautySum(String s) {
    //     int n=s.length();
    //     if(n<=1) return 0; // as hi - lo == 1-1 = 0 == 0-0
    //     int sum=0;
    //     for(int i=0; i<n; i++) // i tracks start point of substring
    //     {

    //         for(int j=i; j<n; j++) // j tracks end point of substring
    //         {
    //             String sub=s.substring(i, j+1);
    //             System.out.println(sub + ": ");
    //             sum+= beauty(sub);
    //         }
    //     } return sum;
    // }

    // private int beauty(String s){
    //     int n=s.length();
    //     if(n<=1) return 0; // as hi - lo == 1-1 = 0 == 0-0
    //     int freq[] = new int[26]; // lowercase
    //     int max=-1; int maxI=-1;
    //     int min=n; int minI=n;
    //     for(char ch: s.toCharArray()){
    //         int ind = ch - 'a';
    //         freq[ind]++;
    //         max=(freq[ind]>max)? freq[ind] : max;
    //         // min=(freq[ind]<min)? freq[ind] : min;
    //         if(freq[ind]<=min){
    //             minI=ind;
    //             min=freq[ind];
    //         }
    //         if(ind == minI && freq[ind]>min) {
    //             min=freq[ind];
    //         }
    //         // if(ind!=minI){
    //         //     minI=ind;
    //         // }
    //         System.out.println("min= "+min+" max= "+max+" diff= "+(max - min));
    //     }
    //     //int beauty = max - min;
    //     return max - min;
    //     /*
    //                 * bcbaa:
    //         min= 1 max= 1 diff= 0
    //         min= 1 max= 1 diff= 0
    //         min= 1 max= 2 diff= 1
    //         min= 1 max= 2 diff= 1
    //         min= 2 max= 2 diff= 0
    //                 */
    // }