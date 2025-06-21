package Arrays.Easy;
import java.util.Arrays;
//q10
public class MissingNo {

    MissingNo(){}

    public static int missingNo(int[]nums){
        int n=nums.length;

        int g=((n)*(n+1))/2;

        //for(int i) no need to iterate, stream is my new best friend tho he is slow
        int sum = Arrays.stream(nums).sum();
        System.out.println("The sum of the numbers in the array is: " + sum);
        return g-sum;
    }



    public static void main(String[] args) {
        int[] arr = {0,1,3,4,5};
        int k = 86;
        int missing=MissingNo.missingNo(arr);
        System.out.println("missing no.= "+ missing);
    
        
    }
    
}
//lc submission
// class Solution {
//     public int missingNumber(int[] nums) {
//                 int n=nums.length;

//         int g=((n)*(n+1))/2;

//         int sum = 0;
//         for(int i=0;i<n;i++){
//             sum+=nums[i];
//         }
//         return g-sum;

//     }
// }

//lc iterator soln
// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         boolean[] check = new boolean[nums.length + 1];
//         for (int num : nums) {
//             check[num] = true;
//         }
//         for (int i = 0; i < n; i++) {
//             if (!check[i]) {
//                 return i;
//             }
//         }
//         return n;
//     }
// }

// XOR lc submission
// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         int ans = 0;
//         for (int i = 0; i <= n-1; i++) {
//             ans = ans ^ i ^ nums[i];
//         }
        
//             ans = ans ^ n;
        
//         return ans;

//     }
// }