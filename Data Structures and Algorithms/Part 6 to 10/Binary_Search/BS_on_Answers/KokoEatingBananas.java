package Binary_Search.BS_on_Answers;
/*
 * Q3
 * Koko Eating Bananas

Problem Statement: A monkey is given ‘n’ piles of bananas, whereas the 'ith' pile has ‘a[i]’ bananas. An integer ‘h’ is also given, which denotes the time (in hours) for all the bananas to be eaten.

Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ bananas. If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas and won’t eat any more bananas in that hour.

Find the minimum number of bananas ‘k’ to eat per hour so that the monkey can eat all the bananas within ‘h’ hours.

Examples
Example 1:
Input Format:
 N = 4, a[] = {7, 15, 6, 3}, h = 8
Result:
 5
Explanation:
 If Koko eats 5 bananas/hr, he will take 2, 3, 2, and 1 hour to eat the piles accordingly. So, he will take 8 hours to complete all the piles.  

Example 2:
Input Format:
 N = 5, a[] = {25, 12, 8, 14, 19}, h = 5
Result:
 25
Explanation:
 If Koko eats 25 bananas/hr, he will take 1, 1, 1, 1, and 1 hour to eat the piles accordingly. So, he will take 5 hours to complete all the piles.


Before moving on to the solution, let’s understand how Koko will eat the bananas. Assume, the given array is {3, 6, 7, 11} and the given time i.e. h is 8. 

First of all, Koko cannot eat bananas from different piles. He should complete the pile he has chosen and then he can go for another pile.
Now, Koko decides to eat 2 bananas/hour. So, in order to complete the first he will take
3 / 2 = 2 hours. Though mathematically, he should take 1.5 hrs but it is clearly stated in the question that after completing a pile Koko will not consume more bananas in that hour. So, for the first pile, Koko will eat 2 bananas in the first hour and then he will consume 1 banana in another hour. 
From here we can conclude that we have to take ceil of (3/2). Similarly, we will calculate the times for other piles.

1st pile: ceil(3/2) = 2 hrs
2nd pile: ceil(6/2) = 3 hrs
3rd pile: ceil(7/2) = 4 hrs
4th pile: ceil(11/2) = 6 hrs
Koko will take 15 hrs in total to consume all the bananas from all the piles. 

Observation: Upon observation, it becomes evident that the maximum number of bananas (represented by 'k') that Koko can consume in an hour is obtained from the pile that contains the largest quantity of bananas. Therefore, the maximum value of 'k' corresponds to the maximum element present in the given array.

So, our answer i.e. the minimum value of ‘k’ lies between 1 and the maximum element in the array i.e. max(a[]).

Now, let’s move on to the solution.
 */
// Attempt 4 at later time
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        if (h < n) return -1; // Not possible to eat all piles if hours are less than piles, even with 1 pile/hr. speed

        // Find the max pile size
        int max = piles[0];
        for(int i=1; i<n; i++) max=(piles[i]>max)? piles[i]:max;
        if (h == n) return max; // If hours are exactly the number of piles, eat at 1 pile/hr. speed

        // Ini. range for binary search
        int l = 1;
        int r = max;
        int k = max;

        while (l <= r) {
            int m = l + (r - l) / 2;
            long hours = 0; // Use long to prevent overflow

            // Calc. the total hours needed at eating speed m
            for (int pile : piles) {
                hours += (pile + m - 1) / m; // Equivalent to ceil(pile / m)
                if (hours > h) break; // Early exit if hours exceed h
            }

            if (hours <= h) {
                k = m; // Update the minimum possible eating speed
                r = m - 1; // Try to find a smaller valid eating speed
            } else {
                l = m + 1; // Increase the eating speed
            }
        }

        return k;
    }

    public static void main(String[] args) {
        KokoEatingBananas koko = new KokoEatingBananas();

        // Test cases
        int[][] testPiles = {
            {7, 15, 6, 3},
            {25, 12, 8, 14, 19},
            {805306368, 805306368, 805306368}
        };
        int[] testHours = {8, 5, 1000000000};

        for (int i = 0; i < testPiles.length; i++) {
            int result = koko.minEatingSpeed(testPiles[i], testHours[i]);
            System.out.println("Minimum eating speed for test case " + (i + 1) + " is: " + result);
        }
    }
}


// public class KokoEatingBananas {
//     public int minEatingSpeed(int[] piles, int h) {
//        /* Attempt 2: works for all cases where overflow ain't an concern
//         int n = piles.length;
//         if (h < n) return -1; // Not possible to eat all piles if hours are less than piles

//         // Find the max pile size
//         int max = piles[0];
//         for (int i = 1; i < n; i++) {
//             max = Math.max(piles[i], max);
//         }
//         if (h == n) return max; // If hours are exactly the number of piles, eat one pile per hour

//         // Ini. range for binary search
//         int l = 1;
//         int r = max;
//         int k = max; // k is speed/rate of eating banaas/hr.

//         while (l <= r) {
//             int m = l + (r - l) / 2;
//             int hours = 0;

//             // Calc. total hours needed at eating speed m
//             for (int pile : piles) {
//                 hours += (pile + m - 1) / m; // == ceil(pile / m)
//             }

//             if (hours <= h) {
//                 k = m; // Update the minimum possible eating speed
//                 r = m - 1; // Try to find a smaller valid eating speed
//             } else {
//                 l = m + 1; // Increase the eating speed
//             }
//         }

//         return k;
//         */

        
//     }
//     public static void main(String[] args) {
//         KokoEatingBananas koko = new KokoEatingBananas();

//         // Test cases
//         int[][] testPiles = {
//             {7, 15, 6, 3},
//             {25, 12, 8, 14, 19}
//         };
//         int[] testHours = {8, 5};

//         for (int i = 0; i < testPiles.length; i++) {
//             int result = koko.minEatingSpeed(testPiles[i], testHours[i]);
//             System.out.println("Minimum eating speed for test case " + (i + 1) + " is: " + result);
//         }
//     }
// }
// // lc submission 1, some mistakes
// /*
//  * class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int n=piles.length;
//         if(h<n) return -1; //Not possible to eat all piles if hours less than piles, even with 1 pile/hr. speed
//         int max=piles[0];
//         for(int i=1; i<n; i++) max=(piles[i]>max)? piles[i]:max;
//         if(h==n) return max; //in this case, have to ensure we go at 1 pile/hr. speed on all piles

//         // Ini. Range for Binary Search
//         int l=1; int  r=max; int k=max; // k is speed/rate of eating banaas/hr.
//         while(l<=r){
//             int m=l+(r-l)/2;
//             int hours=0;
//             for(int pile : piles){
//                 hours+=pile/m+pile%m; // ceil of (piles[i]/m)
//             }
//             if(hours<h) // Too fast
//             {
//                 //actually not require this below line due to convergence prop. of BSrch
//                 k=(m<k)? m:k; // if m is slower yet still allow completion of all bananas, update k
//                 //k=m; //is enough
//                 r=m-1; // try to slow
//             }
//             else if(hours>h) // Too slow
//             {
//                 l=m+1; // try to hasten
//             }
//             else if(hours==h) return m; //just right speed
//         } return k;  
        
//     }
// }
//  */

 