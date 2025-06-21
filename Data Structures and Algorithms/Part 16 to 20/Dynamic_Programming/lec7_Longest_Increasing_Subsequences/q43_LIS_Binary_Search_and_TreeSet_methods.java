package Dynamic_Programming.lec7_Longest_Increasing_Subsequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class q43_LIS_Binary_Search_and_TreeSet_methods {
     public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++)
        {
            Integer x=set.ceiling(nums[i]);
            if(x!=null)
            {
                set.remove(x);
            }
            set.add(nums[i]);
        }
        return set.size();
    }

    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int arr[]) {
        int n = arr.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                // arr[i] > the last element of temp array

                temp.add(arr[i]);
                len++;
            } else {
                // Replacement step
                int ind = Collections.binarySearch(temp, arr[i]);

                if (ind < 0) {
                    ind = -ind - 1;
                }

                temp.set(ind, arr[i]);
            }
        }

        return len;
    }
}
