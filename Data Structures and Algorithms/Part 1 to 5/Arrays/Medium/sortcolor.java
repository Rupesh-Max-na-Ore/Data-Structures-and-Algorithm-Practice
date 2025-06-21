package Arrays.Medium;
//q2
// 75. Sort Colors
// Solved
// Medium
// Topics
// Companies
// Hint
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function.

 

// Example 1:

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:

// Input: nums = [2,0,1]
// Output: [0,1,2]
 

// Constraints:

// n == nums.length
// 1 <= n <= 300
// nums[i] is either 0, 1, or 2.
 

// Follow up: Could you come up with a one-pass algorithm using only constant extra space?

// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 1.9M
// Submissions
// 3.1M
// Acceptance Rate
// 62.3%
public class sortcolor {
    public static int[] sortColors(int[] nums) {
        int c0 =0;
        int c1 =0;
        int c2 =0;
        int l = nums.length;

        for(int i =0; i<l;i++){
            switch(nums[i]){
                case 0:
                    c0++;
                    break;
                case 1:
                    c1++;
                    break;
                case 2:
                    c2++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("c0 =" + c0);
        System.out.println("c1 =" + c1);
        System.out.println("c2 =" + c2);
        System.out.println((c0+c1+c2)==l);

        for(int i = 0; i<c0;i++){nums[i]=0;}
        for(int i = c0; i<c0+c1;i++){nums[i]=1;}
        for(int i = c0+c1; i<c0+c1+c2;i++){nums[i]=2;}

        return nums;

    }

    static void printArr(int nums[]){

        for(int i = 0; i< nums.length;i++){
            System.out.print( nums[i] + " " );
        }

    }

    public static void main(String[] args) {
        int arr[]= {1,1,0,0,2,1,2,1,0};
        System.out.print("Original array: ");
        printArr(arr);
        System.out.println();
        arr=sortColors(arr);
        System.out.print("New array: ");
        printArr(arr);
        System.out.println();


    }
}

//lc submission 1
// public static int[] sortColors(int[] nums) {
//     int c0 =0;
//     int c1 =0;
//     int c2 =0;
//     int l = nums.length;

//     for(int i =0; i<l;i++){
//         switch(nums[i]){
//             case 0:
//                 c0++;
//                 break;
//             case 1:
//                 c1++;
//                 break;
//             case 2:
//                 c2++;
//                 break;
//             default:
//                 break;
//         }
//     }
//     System.out.println("c0 =" + c0);
//     System.out.println("c1 =" + c1);
//     System.out.println("c2 =" + c2);
//     System.out.println((c0+c1+c2)==l);

//     for(int i = 0; i<c0;i++){nums[i]=0;}
//     for(int i = c0; i<c0+c1;i++){nums[i]=1;}
//     for(int i = c0+c1; i<c0+c1+c2;i++){nums[i]=2;}

//     return nums;

// }

//lc submission 2
// class Solution {
//     public void sortColors(int[] nums) {
//         int[] c= {0,0,0};
//         int l = nums.length;

//         for(int i =0; i<l;i++){
//             c[nums[i]]++;
//         }

//         int k = -1;

//         for(int i =0; i<=2;i++){
//             for(int j = 0;j< c[i];j++)
//                 nums[++k] = i;
//         }

// }}