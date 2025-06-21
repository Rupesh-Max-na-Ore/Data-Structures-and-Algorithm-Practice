package Binary_Search.BS_on_Answers;
/*
 * Q4
 * Minimum days to make M bouquets

Problem Statement: You are given 'N’ roses and you are also given an array 'arr'  where 'arr[i]'  denotes that the 'ith' rose will bloom on the 'arr[i]th' day.
You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.
Find the minimum number of days required to make at least ‘m' bouquets each containing 'k' roses. Return -1 if it is not possible.

Examples
Example 1:
Input Format:
 N = 8, arr[] = {7, 7, 7, 7, 13, 11, 12, 7}, m = 2, k = 3
Result:
 12
Explanation:
 On the 12th the first 4 flowers and the last 3 flowers would have already bloomed. So, we can easily make 2 bouquets, one with the first 3 and another with the last 3 flowers.

Example 2:
Input Format:
 N = 5, arr[] = {1, 10, 3, 10, 2}, m = 3, k = 2
Result:
 -1
Explanation:
 If we want to make 3 bouquets of 2 flowers each, we need at least 6 flowers. But we are given only 5 flowers, so, we cannot make the bouquets.


Let's grasp the question better with the help of an example. Consider an array: {7, 7, 7, 7, 13, 11, 12, 7}. We aim to create bouquets with k, which is 3 adjacent flowers, and we need to make m, which is 2 such bouquets. Now, if we try to make bouquets on the 11th day, the first 4 flowers and the 6th and the last flowers would have bloomed. So, we will be having 6 flowers in total on the 11th day. However, we require two groups of 3 adjacent flowers each. Although we can form one group with the first 3 adjacent flowers, we cannot create a second group. Therefore, 11 is not the answer in this case.

If we choose the 12th day, we can make 2 such groups, one with the first 3 adjacent flowers and the other with the last 3 adjacent flowers. Hence, we need a minimum of 12 days to make 2 bouquets.

Observation: 

Impossible case: To create m bouquets with k adjacent flowers each, we require a minimum of m*k flowers in total. If the number of flowers in the array, represented by array-size, is less than m*k, it becomes impossible to form m bouquets even after all the flowers have bloomed. In such cases, where array-size < m*k, we should return -1.
 Maximum possible answer: The maximum potential answer corresponds to the time needed for all the flowers to bloom. In other words, it is the highest value within the given array i.e. max(arr[]).
Minimum possible answer: The minimum potential answer corresponds to the time needed for atleast one flower to bloom. In other words, it is the smallest value within the given array i.e. min(arr[]).
Note: From the above observations, we can conclude that our answer lies between the range [min(arr[]), max(arr[])].

How to calculate the number of bouquets we can make on dth day:

We will count the number of adjacent bloomed flowers(say cnt) and whenever we get a flower that is not bloomed, we will add the number of bouquets we can make with ‘cnt’ adjacent flowers i.e. floor(cnt/k) to the answer. We will follow the process throughout the array. 

Now, we will write a function possible(), that will return true if, on a certain day, we can make at least m bouquets otherwise it will return false. The steps will be the following:

possible(arr[], day, m, k) algorithm:

We will declare two variables i.e. ‘cnt’ and ‘noOfB’.
cnt -> the number of adjacent flowers,
noOfB -> the number of bouquets.
We will run a loop to traverse the array.
Inside the loop, we will do the following:
If arr[i] <= day: This means the ith flower has bloomed. So, we will increase the number of adjacent flowers i.e. ‘cnt’ by 1.
Otherwise, the flower has not bloomed. Here, we will calculate the number of bouquets we can make with ‘cnt’ adjacent flowers i.e. floor(cnt/k), and add it to the noOfB. Now, as this ith flower breaks the sequence of the adjacent bloomed flowers, we will set the ‘cnt’ 0.
Lastly, outside the loop, we will calculate the floor(cnt/k) and add it to the noOfB.
If noOfB >= m: This means, we can make at least m bouquets. So, we will return true.
Otherwise, We will return false.
Note: We actually pass a particular day as a parameter to the possible() function. The function returns true if it is possible to make atleast m bouquets on that particular day, otherwise, it returns false.
 */
public class RoseGarden {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<((long)m*k)) return -1; // Not enough roses to make the required bouquets = m
        //Find (max) no. of days to wait for all roses to bloom & (min.)no. of days for atleast 1 rose to bloom
        int max=bloomDay[0]; int min=max;
        for(int i=1; i<n; i++) 
        {   
            max=(bloomDay[i]>max)? bloomDay[i]:max;
            min=(bloomDay[i]<min)? bloomDay[i]:min;
        }
        if(m*k==n) return max; //if all roses needed, wait for day till all roses bloomed
        //Ini. range for BinSrch
        int l=min; int r=max; int ans=max;// ans stores min days we neeed to wait to make m bouquets
        while(l<=r){
            int mid=l+(r-l)/2;
            int cntF=0; int cntB=0;
            // Loop to check if it's possible to make at least m bouquets on a given day
            for(int bd:bloomDay){
                if(bd<=mid) cntF++; // count flowers in continuous clusters
                else // when cluster line interrupted
                {
                    //find max no. of bouquets that can be salvaged out of that cluster
                    cntB+= cntF/k; //== floor(cntF/k)
                    cntF=0;
                    if(cntB>=m) break;
                } 
            } cntB+= cntF/k; // for last cluster, if garden ends in a cluster too
            if(cntB>=m)
            {
                ans=mid;//possible ans
                r=mid-1;//try to find lower valid ans still
            }
            else if((cntB<m))
            {
                l=mid+1;//try to wait higher no.of days with hope to get to cntB to m
            }
        } return ans; // or just return l
    }


        

    public static void main(String[] args) {
        RoseGarden rg = new RoseGarden();

        // Test cases
        int[][] testBloomDays = {
            {7, 7, 7, 7, 13, 11, 12, 7},
            {1, 10, 3, 10, 2},
            {805306368, 805306368, 805306368}
        };
        int[] testBouquets = {2, 3, 1};
        int[] testRoses = {3, 2, 3};

        for (int i = 0; i < testBloomDays.length; i++) {
            int result = rg.minDays(testBloomDays[i], testBouquets[i], testRoses[i]);
            System.out.println("Minimum days for test case " + (i + 1) + " is: " + result);
        }
    }
}
