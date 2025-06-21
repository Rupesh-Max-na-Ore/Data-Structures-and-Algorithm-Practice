package StackAndQueue.Lec3_MonotonicStackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/*Q9 402. Remove K Digits
Medium
Topics
Companies
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
Seen this question in a real interview before?
1/5
Yes
No
Accepted
489.9K
Submissions
1.5M
Acceptance Rate
33.6% */
public class Remove_K_digits {
    public String removeKdigits(String str, int k) {        
        if(k >= str.length()) return "0";// remove all

        Deque<Character> st = new ArrayDeque<>();
        for(char c : str.toCharArray()) {
            while(k > 0 && !st.isEmpty() && st.peekLast() > c) {
                st.removeLast(); // using deque like stack, as pop == removeFirst() == remove from last put, LIFO
                k--;
            }
            st.addLast(c);
        }
        
        while(k>0) {
            st.removeLast(); // like pop()
            k--;
        }
        
        // Remove all 0s from the front of the st and then chk. if st is empty, if yes, return "0"
        while(!st.isEmpty() && st.peekFirst()== '0') st.removeFirst();
        if(st.isEmpty()) return "0";

        // build no. from st contents of (n - k -#leading 0s)
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.removeFirst());// Using deque like in Queue, as removeFirst() == Dequeue == remove from front, FIFO
        }
        return sb.toString();
    }
}
/* very good thread -
 * https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack
 */
/*
// a stack soln.
public String removeKdigits(String num, int k) {
        int len = num.length();
        //corner case
        if(k==len)        
            return "0";
            
        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        
        // corner case like "1111"
        while(k>0){
            stack.pop();
            k--;            
        }
        
        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
 */
/*// a string soln.
public class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder result = new StringBuilder(); // it will act like a stack
        int n = num.length();
        
        for(int i = 0; i < n; i++) {
            while(result.length() > 0 && result.charAt(result.length() - 1) > num.charAt(i) && k > 0) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            
            if(result.length() > 0 || num.charAt(i) != '0') {
                result.append(num.charAt(i)); // to avoid the case when we have preceding zeros
            }
        }
        
        while(result.length() > 0 && k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }

        if(result.length() == 0) {
            return "0";
        }
        
        return result.toString();
    }
}
 */

/*//Queue soln. on LC forum, very long
class Solution {
    public String removeKdigits(String nums, int k) {
        
        //look for longest zeros before k get removed
        int index = 0, count = 0, removed=0;
        for(int i=0; i<nums.length(); i++){
            int num = nums.charAt(i)-'0';
            if(num > 0)count++;
            if(count > k)break;
            if(num == 0){
                index = i+1;
                removed = count;
            }
        }
        //exit if remaining digits less than remaining k
        k -= removed;
        if(nums.length() - index <= k)return "0";
        
        //store the next remaining k elements in a priority queue
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        for(int i=0; i<k; i++){
            pq.offer(new int[]{i+index,nums.charAt(i+index)-'0'});
        }
        //start comparing the remaining with priority queu
        //1. when current is less than priority queue, clear everything in the priority queue
        //2. else, poll from priority queue and replace the current. then remove all digits
        //   in the priorityqueue before the polled one
        for(int i=k+index; i<nums.length(); i++){
            int nn = nums.charAt(i)-'0';
            if(pq.isEmpty()){
                sb.append(nn);
                continue;
            }
            if( nn < pq.peek()[1]){
                sb.append(nn);
                pq.clear();
                continue;
            }
            int[] cur = pq.poll();
            sb.append(cur[1]);
            PriorityQueue<int[]> temp = new PriorityQueue<>((a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
            while(!pq.isEmpty()){
                if(pq.peek()[0] > cur[0])
                    temp.offer(pq.poll());
                else
                    pq.poll();
            }
            temp.offer(new int[]{i,nn});
            pq = temp;
            
        }
        return sb.length()==0?"0":sb.toString();        
    }
}
    //https://leetcode.com/problems/remove-k-digits/solutions/1780891/java-solution-priorityqueue-faster-than-official-solution/
*/