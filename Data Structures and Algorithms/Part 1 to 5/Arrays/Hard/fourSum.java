package Arrays.Hard;
/*
 * Q4
 * 4 Sum | Find Quads that add up to a target value


11

0
Problem Statement: Given an array of N integers, your task is to find unique quads that add up to give a target value. In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]] such that their sum is equal to a given target.

Pre-req: 3-sum problem and 2-sum problem

Note:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
arr[a] + arr[b] + arr[c] + arr[d] == target

Examples
Example 1:
Input Format:
 arr[] = [1,0,-1,0,-2,2], target = 0
Result:
 [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Explanation:
 We have to find unique quadruplets from the array such that the sum of those elements is equal to the target sum given that is 0. The result obtained is such that the sum of the quadruplets yields 0.

Example 2:
Input Format:
 arr[] = [4,3,3,4,4,2,1,2,1,1], target = 9
Result:
 [[1,1,3,4],[1,2,2,4],[1,2,3,3]]
Explanation:
 The sum of all the quadruplets is equal to the target i.e. 9.
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    

    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans = fourSumI(nums, target);
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    private static List<List<Integer>> fourSumI(int[] a, int k) {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'fourSumI'");
        int n=a.length;
        List<List<Integer>> al=new ArrayList<>();
        Arrays.sort(a);
        int fl,fr,ml,mr,s=0;//fixed left and right, moving left and right
        for(fl=0;fl<n;fl++){
            if(fl>0 && a[fl]==a[fl-1]) continue;//fl++;--> cause repetition if reps are >1
            for(fr=fl+1;fr<n;fr++){
                if(fr>fl+1 && a[fr]==a[fr-1]) continue;//fr++;--> cause repetition if reps are >1

                //2 ptr. tech.
                ml=fr+1;
                mr=n-1;

                while(mr>ml){
                    s=a[fl]+a[fr]+a[ml]+a[mr];
                    if(s<k) ml++;
                    else if(s>k) mr--;
                    else if(s==k) {
                        al.add(Arrays.asList(a[fl],a[fr],a[ml],a[mr]));
                        mr--;ml++;
                        if(ml<mr && a[ml]==a[ml-1]) ml++;//being not at head, but tail, correct here, continue won't do anything here
                        if(mr>ml && a[mr]==a[mr+1]) mr--;//being not at head, but tail, correct here, continue won't do anything here

                    }
                }
            }
        }

        return al;

    }
}

// //lc submission 1, not work for only 1 case
// class Solution {
//     public List<List<Integer>> fourSum(int[] a, int k) {
//                 int n=a.length;
//         List<List<Integer>> al=new ArrayList<>();
//         Arrays.sort(a);
//         int fl,fr,ml,mr,s=0;//fixed left and right, moving left and right
//         for(fl=0;fl<n;fl++){
//             if(fl>0 && a[fl]==a[fl-1]) continue;//fl++;--> cause repetition if reps are >1
//             for(fr=fl+1;fr<n;fr++){
//                 if(fr>fl+1 && a[fr]==a[fr-1]) continue;//fr++;--> cause repetition if reps are >1

//                 //2 ptr. tech.
//                 ml=fr+1;
//                 mr=n-1;

//                 while(mr>ml){
//                     s=a[fl]+a[fr]+a[ml]+a[mr];
//                     if(s<k) ml++;
//                     else if(s>k) mr--;
//                     else if(s==k) {
//                         al.add(Arrays.asList(a[fl],a[fr],a[ml],a[mr]));
//                         mr--;ml++;
//                         while(ml<mr && a[ml]==a[ml-1]) ml++;//use while,not if, and being not at head, but tail, correct here, continue won't do anything here
//                         while(mr>ml && a[mr]==a[mr+1]) mr--;//being not at head, but tail, correct here, continue won't do anything here

//                     }
//                 }
//             }
//         }

//         return al;

//     }
// }

//lc submission 2, works
// class Solution {
//     public List<List<Integer>> fourSum(int[] a, int k) {
//         int n = a.length;
//         List<List<Integer>> al = new ArrayList<>();
//         if (n < 4) return al;  // Early return if there are fewer than 4 elements

//         Arrays.sort(a);
//         int fl, fr, ml, mr;

//         for (fl = 0; fl < n - 3; fl++) {
//             if (fl > 0 && a[fl] == a[fl - 1]) continue;  // Avoid duplicates for fl

//             for (fr = fl + 1; fr < n - 2; fr++) {
//                 if (fr > fl + 1 && a[fr] == a[fr - 1]) continue;  // Avoid duplicates for fr

//                 // 2-pointer technique
//                 ml = fr + 1;
//                 mr = n - 1;

//                 while (mr > ml) {
//                     long s = (long) a[fl] + (long) a[fr] + (long) a[ml] + (long) a[mr];
//                     if (s < k) {
//                         ml++;
//                     } else if (s > k) {
//                         mr--;
//                     } else {
//                         al.add(Arrays.asList(a[fl], a[fr], a[ml], a[mr]));
//                         ml++;
//                         mr--;
//                         // Skip duplicates for ml and mr
//                         while (ml < mr && a[ml] == a[ml - 1]) ml++;
//                         while (ml < mr && a[mr] == a[mr + 1]) mr--;
//                     }
//                 }
//             }
//         }

//         return al;
//     }
// }