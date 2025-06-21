package Arrays.Hard;
// //q8
// Merge two Sorted Arrays Without Extra Space


// 22

// 1
// Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

// Examples
// Example 1:
// Input:
 
// n = 4, arr1[] = [1 4 8 10] 
// m = 5, arr2[] = [2 3 9]

// Output:
 
// arr1[] = [1 2 3 4]
// arr2[] = [8 9 10]

// Explanation:

// After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

// Example2:
// Input:
 
// n = 4, arr1[] = [1 3 5 7] 
// m = 5, arr2[] = [0 2 6 8 9]

// Output:
 
// arr1[] = [0 1 2 3]
// arr2[] = [5 6 7 8 9]

// Explanation:

// After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
import java.util.Arrays;

public class merge2arr {
    // will do way 2: gap method later
    //way 1: general soln
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int l2=0;
        int r1=m-1;
        while(m!=0 && n!=0 && nums1[r1]>nums2[l2] && l2 < n && r1>=0)
        {
            int temp=nums1[r1];
            nums1[r1]=nums2[l2];
            nums2[l2]=temp;
            r1--;
            l2++;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
     public static void main(String[] args) {
        int[] a1 = {1, 8, 7, 56, 90}; Arrays.sort(a1);
        int[] a2 = {3, 4, 5, 1, 2}; Arrays.sort(a2);
        
        System.out.println("Original array1: " + Arrays.toString(a1));

        System.out.println("Original array2: " + Arrays.toString(a2));
        

        merge(a1, a1.length, a2, a2.length);

        System.out.println("Sorted array1: " + Arrays.toString(a1));

        System.out.println("Sorted array2: " + Arrays.toString(a2));


    }
    
    
}
// //lc88 optimized submission
// class Solution {
//     public void merge(int[] num1, int m, int[] num2, int n) {
//     int l=m-1; int r=n-1; int p=m+n-1;
//     //run loop until a2 exhausted
//     //that is r becomes <0
//     // or p goes == l
//     while(r>=0||p>l){
//         // when a1 has elems and a1[l] is more than a2[r]
//         if(l>=0 && num1[l]>=num2[r]){
//             num1[p--]=num1[l--];
//         }
//         //when either a1 got no elems or a1[l] is more than a2[r]
//         else if(l==-1||num1[l]<num2[r])
//         {
//             num1[p--]=num2[r--];
//         }
//         // //can skip
//         // if(l==p) break;// it's over when l==p, but that only happens when a2 exhausted
        
//     }

//     }    
// }

// shorter lc88 soln
// class Solution {
//     public void merge(int[] num1, int m, int[] num2, int n) {
//     int l=m-1; int r=n-1; int p=m+n-1;
//     while(r>=0 && p>=0){
//         if(l>=0 && num1[l]>num2[r]){
//             num1[p--]=num1[l--];
//         }else
//         {
//             num1[p--]=num2[r--];
//         }
//     }

//     }    
// }