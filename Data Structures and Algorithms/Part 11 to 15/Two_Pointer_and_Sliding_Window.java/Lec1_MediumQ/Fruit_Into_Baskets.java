package Two_Pointer_and_Sliding_Window.java.Lec1_MediumQ;

import java.util.HashMap;

/*Q3 904. Fruit Into Baskets
Medium
Topics
Companies
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

 

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
 

Constraints:

1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length
Seen this question in a real interview before?
1/5
Yes
No
Accepted
416.3K
Submissions
934.9K
Acceptance Rate
44.5% */
public class Fruit_Into_Baskets {
    public int totalFruit(int[] fruits) {
        int maxL=0; int l=0,r=0;
        HashMap<Integer, Integer> hmap=new HashMap<>();
        while(r<fruits.length){
            hmap.put(fruits[r], (hmap.getOrDefault(fruits[r], 0)+1));
            if(hmap.size()>2){
                hmap.put(fruits[l], (hmap.getOrDefault(fruits[l], 0)-1));
                if(hmap.get(fruits[l])==0) hmap.remove(fruits[l]);
                l++;
            }
            maxL = Math.max(maxL, (r-l+1));
            r++;
        } return maxL;
    }
}
/*
//Compact Soln.
Java:

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, j;
        for (j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            if (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                count.remove(tree[i++], 0);
            }
        }
        return j - i;
    }
Java

    public int totalFruit2(int[] tree) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, i = 0;
        for (int j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                if (count.get(tree[i]) == 0) count.remove(tree[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    class Solution {
    public int totalFruit(int[] tree) {
        int start = 0;
        int n = tree.length;
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int end = 0; end < n; end++) {
            map.put(tree[end], end);
            if (map.size() > 2) {
                int minIndex = Collections.min(map.values());
                map.remove(tree[minIndex]);
                start = minIndex + 1;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
 */