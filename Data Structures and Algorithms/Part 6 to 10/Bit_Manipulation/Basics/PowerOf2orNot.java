package Bit_Manipulation.Basics;
/*Q4  231. Power of Two
Easy
Topics
Companies
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

 

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false
 

Constraints:

-231 <= n <= 231 - 1
 

Follow up: Could you solve it without loops/recursion?
Seen this question in a real interview before?
1/5
Yes
No
Accepted
1.3M
Submissions
2.8M
Acceptance Rate
47.8%*/
public class PowerOf2orNot {
    public boolean isPowerOfTwo(int n) {
        //first attempt
        // if((n&(n-1))==0) return true;// fail tc, n=0
        // //else
        // return false;
        if((n>0) && ((n&(n-1))==0)) return true;
        //else
        return false;
    }
}
/*
//found some elegant solns. on LC forum
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}

public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n)==1;
    }

    public boolean isPowerOfTwo(int n) {
        return (((n&(-1*n)) == n) && n!=0);
    }
*/
/*
 * C++ EASY TO SOLVE || All INTERVIEW APPROACHES with Detailed Explanations

Cosmic_Phantom
Annual Badge 2023
5684
77862
Dec 21, 2021
C++
C
Bit Manipulation
Recursion
Intuition:
Well well, the question is quite the tough one today. So make your focus lasersharp and let's jump in. The question is return true or false if the given n is power of two or not. The simple approach that comes to mind after reading this, is our classsic reminder and divident menthod that we used for finding odd and even . The question is easy but can be solved in tooo many ways .Try to understand all the solution as it may help in interviews where there can be restriction of using certain methods

Codes:-

1. Using Reminder-divident method:-

class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n==0) return false;
        while(n%2==0) n/=2;
        return n==1;
    }
};
Time Complexity: O(logn)
Space Complexity: O(1)

2. Using Reminder-divident method via Recursion:-

class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n==0) return false;
        return ((n==1) || (n%2==0 && isPowerOfTwo(n/2)));
    }
};
Time Complexity : O(logn)
Space Complexity : O(logn) [Rcursive stack is counted]

3. Bit manipulation :-
Tip: Always remember that bit manipulation techniques are usually based on observations from multiple examples

Let's take some good exampes :
number->binary form
3->0000 0011
4->0000 0100
5->0000 0101
6->0000 0110
7->0000 0111
8->0000 1000
The observation we can conclude is that the number which is a power of two has always compulsoryily 1 true bit.

Now consider :-
bit representation of 7  -> 0111
bit representation of 8  -> 1000
bitwise AND of 7 and 8 -> 0000
we are gonna use this property for for all numbers which are powers of two
class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n<=0) return false;
        return ((n&(n-1))==0);
    }
};
Time Complexity : O(1)
Space Complexity : O(1)

4. Using ceil-floor method

class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return ceil(log2(n)) == floor(log2(n));
    }
};
Time Complexity : O(logn)
Space Complexity : O(1)

5. Using C++ STL method #Thanks to @rajab1691 :)

class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n<0)return false;
        
        int bits=__builtin_popcount(n);
        
        if(bits==1)
            return true;
        return false;
    }
};
6. LMAO method
We are literally gonna take the advantage of the constraints. I dont recommend you all to use this method during your interviews. It's a fun method . Do this on your own, you will enjoy it ;))

Hint:Constraints [-2^31 <= n <= 2^31 - 1] also 2^30 is 1073741824
class Solution {
public:
    bool isPowerOfTwo(int n) {
        if(n==0) return false;
        return (n>0)&&(1073741824%n==0);
    }
};
Time Complexity : O(1)
Space Complexity : O(1)

Here's my github link where I keep my solutions.

Feel free to comment if you have some suggestion or upvote if you liked my post ;)
//https://leetcode.com/problems/power-of-two/solutions/1638704/c-easy-to-solve-all-interview-approaches-with-detailed-explanations/
 */