package Arrays.Hard;
/*Q2
 * Majority Elements(&gt;N/3 times) | Find the elements that appears more than N/3 times in the array


34

1
Problem Statement: Given an array of N integers. 
Find the elements that appear more than N/3 times in the array. 
If no such element exists, return an empty vector.

Pre-requisite: Majority Element(>N/2 times)

Examples
Example 1:
Input Format
: N = 5, array[] = {1,2,2,3,2}
Result
: 2
Explanation:
 Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.
 Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.

Example 2:
Input Format
:  N = 6, array[] = {11,33,33,11,33,11}
Result:
 11 33
Explanation:
 Here we can see that the Count(11) = 3 and Count(33) = 3. 
 Therefore, the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Majority2 {

    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length; 
        int cnt1 = 0, cnt2 = 0; 
        int e1 = Integer.MIN_VALUE; 
        int e2 = Integer.MIN_VALUE; 
        //int i;
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && e2 != nums[i]) {
                cnt1 = 1;
                e1 = nums[i];
            } else if (cnt2 == 0 && e1 != nums[i]) {
                cnt2 = 1;
                e2 = nums[i];
            } else if (nums[i] == e1) cnt1++;
            else if (nums[i] == e2) cnt2++;
            else {
                cnt1--; cnt2--;
            }
        }

        List<Integer> L = new ArrayList<>(); 

        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == e1) cnt1++;
            if (nums[i] == e2) cnt2++;
        }

        if (cnt1 > n/3) L.add(e1);
        if (cnt2 > n/3) L.add(e2);

        Collections.sort(L); //if require in sorted order
        return L;
    }
    public static void main(String args[]) {
        int[] arr = {1,1,1,1,1,1,3,3,3,3,3,4,4,4,4,4,1,1,1,1,3,3,3,3,3,3};
        List<Integer> majors = majorityElement(arr);
        //simple way to print arraylist using toString()
        System.out.print("Majority elems: " + majors);

        // a way to print list
        // for (int i = 0; i < majors.size(); i++) {
        //     System.out.print(majors.get(i) + " ");
        // }
        System.out.println();
    }
    
}
// // lc submission
// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         int n = nums.length; 
//         int cnt1 = 0, cnt2 = 0; 
//         int e1 = Integer.MIN_VALUE; 
//         int e2 = Integer.MIN_VALUE; 
//         //int i;
//         for (int i = 0; i < n; i++) {
//             if (cnt1 == 0 && e2 != nums[i]) {
//                 cnt1 = 1;
//                 e1 = nums[i];
//             } else if (cnt2 == 0 && e1 != nums[i]) {
//                 cnt2 = 1;
//                 e2 = nums[i];
//             } else if (nums[i] == e1) cnt1++;
//             else if (nums[i] == e2) cnt2++;
//             else {
//                 cnt1--; cnt2--;
//             }
//         }

//         List<Integer> L = new ArrayList<>(); 

//         cnt1 = 0; cnt2 = 0;
//         for (int i = 0; i < n; i++) {
//             if (nums[i] == e1) cnt1++;
//             if (nums[i] == e2) cnt2++;
//         }

//         if (cnt1 > n/3) L.add(e1);
//         if (cnt2 > n/3) L.add(e2);

//         Collections.sort(L); 

//         return L;
//     }
// }