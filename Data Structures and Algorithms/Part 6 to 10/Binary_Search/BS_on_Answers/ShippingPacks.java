package Binary_Search.BS_on_Answers;
/*
 * Q6
 * 
 * Capacity to Ship Packages within D Days

Problem Statement: You are the owner of a Shipment company. You use conveyor belts to ship packages from one port to another. The packages must be shipped within 'd' days.
The weights of the packages are given in an array 'of weights'. The packages are loaded on the conveyor belts every day in the same order as they appear in the array. The loaded weights must not exceed the maximum weight capacity of the ship.
Find out the least-weight capacity so that you can ship all the packages within 'd' days.

Examples
Example 1:
Input Format:
 N = 5, weights[] = {5,4,5,2,3,4,5,6}, d = 5
Result:
 9
Explanation:
 If the ship capacity is 9, the shipment will be done in the following manner:
Day         Weights            Total
1        -       5, 4          -        9
2        -       5, 2          -        7
3        -       3, 4          -        7
4        -       5              -        5
5        -       6              -        6
So, the least capacity should be 9.

Example 2:
Input Format:
 N = 10, weights[] = {1,2,3,4,5,6,7,8,9,10}, d = 1
Result:
 55
Explanation:
 We have to ship all the goods in a single day. So, the weight capacity should be the summation of all the weights i.e. 55.

Observation:

Minimum ship capacity: The minimum ship capacity should be the maximum value in the given array. Let’s understand using an example. Assume the given weights array is {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} and the ship capacity is 8. Now in the question, it is clearly stated that the loaded weights in the ship must not exceed the maximum weight capacity of the ship. For this constraint, we can never ship the weights 9 and 10, if the ship capacity is 8. That is why, in order to ship all the weights, the minimum ship capacity should be equal to the maximum of the weights array i.e. nax(weights[]).
Maximum capacity: If the ship capacity is equal to the sum of all the weights, we can ship all goods within a single day. Any capacity greater than this will yield the same result. So, the maximum capacity will be the summation of all the weights i.e. sum(weights[]).
From the observations, it is clear that our answer lies in the range
[max(weights[]), sum(weights[])].

How to calculate the number of days required to ship all the weights for a certain ship capacity:

In order to calculate this, we will write a function findDays(). This function accepts the weights array and a capacity as parameters and returns the number of days required for that particular capacity. The steps will be the following:

findDays(weights[], cap):

We will declare to variables i.e. ‘days’(representing the required days) and ‘load’ (representing the loaded weights in the ship). As we are on the first day, ‘days’ should be initialized with 1 and ‘load’ should be initialized with 0.
Next, we will use a loop(say i) to iterate over the weights. For each weight, weights[i], we will check the following:
If load+weights[i] > cap: If upon adding current weight with load exceeds the ship capacity, we will move on to the next day(i.e. day = day+1) and then load the current weight(i.e. Set load to weights[i], load = weights[i]).
Otherwise, We will just add the current weight to the load(i.e. load = load+weights[i]).
Finally, we will return ‘days’ which represents the number of days required.

 */
public class ShippingPacks {
    public int shipWithinDays(int[] wt, int d) {
        int n=wt.length;
        if(d>n) return -1; // not possible
        // find max wt, min wt and sum of wts
        int maxWt=wt[0]; int minWt=wt[0]; int wtSum=wt[0];
        for(int i=1; i<n;i++){
            maxWt=(maxWt<wt[i])? wt[i]:maxWt;
            minWt=(minWt>wt[i])? wt[i]:minWt;
            wtSum+=wt[i];
        }
        if(d==1) return wtSum; // to take all in 1 day
        //if(d==n) return maxWt; // to take each item in 1 day-->wrong thinking [2,3,4,9] can be shipped in 2 days with cap=maxWt
        if(d==n && minWt>(maxWt+1)/2) return maxWt; // correct for eg. [50, 50, 99]

        //Ini. for Range of Binsrch
        int l=maxWt;
        int r=wtSum;
        int cap=wtSum;
        while(l<=r){
            int m= l+(r-l)/2;
            // to check if ship of 'm' cap can deliver in d days or not
            // s1- calc days it gonna take for m cap ship to deliver
            int days=1;
            int load=0;
            for(int weight:wt)
            {
                if(load+weight>m){
                    days++; //go to next day
                    load=weight;
                    if(days>d) break; //optimization for large case checking, just directly move on to checking for a higher cap ship that might delivers within d days
                } else load+=weight;
            }
            // s2- actually check if days taken by 'm' cap ship to deliver lies within d
            if(days<=d){
                cap=m;//might be the min. cap that delivers in d days
                r=m-1;//try for a lower cap ship that still delivers within d days
            }else{
                //not gonna do
                l=m+1;//try for a higher cap ship that might delivers within d days
            }

        }return cap; // could just return 'l' too
    }
    public static void main(String[] args) {
        ShippingPacks sp = new ShippingPacks();

        // Test case 1
        int[] weights1 = {5, 4, 5, 2, 3, 4, 5, 6};
        int days1 = 5;
        System.out.println("Test Case 1:");
        System.out.println("Input: weights = {5, 4, 5, 2, 3, 4, 5, 6}, days = 5");
        System.out.println("Output: " + sp.shipWithinDays(weights1, days1)); // Expected output: 9

        // Test case 2
        int[] weights2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days2 = 1;
        System.out.println("\nTest Case 2:");
        System.out.println("Input: weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, days = 1");
        System.out.println("Output: " + sp.shipWithinDays(weights2, days2)); // Expected output: 55
    }
}
