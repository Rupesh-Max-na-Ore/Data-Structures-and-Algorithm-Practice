package Arrays.Medium;
//q7
import java.util.Arrays;

public class rearrangeElemsBySign {
    public static int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] B= new int[n];
        int pos=0; int neg=1;
        for(int i=0; i<n; i++){
            if(nums[i]<0){
                B[neg]=nums[i];
                neg=neg+2;
            }else{
                B[pos]=nums[i];
                pos=pos+2;
            }
        }return B;
        
    }
         public static void main(String[] args) {
        int[] a1 = {-1,1,0,3,-3,4,-5,6,-7,-8};
        int[] a2 = {-1,-2,3};
        
        System.out.println("Original array: " + Arrays.toString(a1));
        int []rea=rearrangeElemsBySign.rearrangeArray(a1);
        System.out.println(" new arr =  "+Arrays.toString(rea));
        }

}

//lc submission
//class Solution {
//     public int[] rearrangeArray(int[] nums) {
//                 int n=nums.length;
//         int[] B= new int[n];
//         int pos=0; int neg=1;
//         for(int i=0; i<n; i++){
//             if(nums[i]<0){
//                 B[neg]=nums[i];
//                 neg=neg+2;
//             }else{
//                 B[pos]=nums[i];
//                 pos=pos+2;
//             }
//         }return B;

//     }
// }

//Variety 2: where no. of +ves and -ves are unknown
//copied from Striver, for now, know how to do it, will do again during revision
// public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A, int n) {
//     // Define 2 ArrayLists, one for storing positive 
//     // and other for negative elements of the array.
//     ArrayList<Integer> pos = new ArrayList<>();
//     ArrayList<Integer> neg = new ArrayList<>();

//     // Segregate the array into positives and negatives.
//     for (int i = 0; i < n; i++) {
//         if (A.get(i) > 0)
//             pos.add(A.get(i));
//         else
//             neg.add(A.get(i));
//     }

//     // If positives are lesser than the negatives.
//     if (pos.size() < neg.size()) {

//         // First, fill array alternatively till the point 
//         // where positives and negatives are equal in number.
//         for (int i = 0; i < pos.size(); i++) {
//             A.set(2 * i, pos.get(i));
//             A.set(2 * i + 1, neg.get(i));
//         }

//         // Fill the remaining negatives at the end of the array.
//         int index = pos.size() * 2;
//         for (int i = pos.size(); i < neg.size(); i++) {
//             A.set(index, neg.get(i));
//             index++;
//         }
//     }

//     // If negatives are lesser than the positives.
//     else {
//         // First, fill array alternatively till the point 
//         // where positives and negatives are equal in number.
//         for (int i = 0; i < neg.size(); i++) {
//             A.set(2 * i, pos.get(i));
//             A.set(2 * i + 1, neg.get(i));
//         }

//         // Fill the remaining positives at the end of the array.
//         int index = neg.size() * 2;
//         for (int i = neg.size(); i < pos.size(); i++) {
//             A.set(index, pos.get(i));
//             index++;
//         }
//     }
//     return A;
// }
