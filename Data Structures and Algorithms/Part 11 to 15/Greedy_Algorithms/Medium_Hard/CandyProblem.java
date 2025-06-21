package Greedy_Algorithms.Medium_Hard;
/*Q6 135. Candy
Hard
Topics
Companies
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
Accepted
561.6K
Submissions
1.3M
Acceptance Rate
43.6% */
public class CandyProblem {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int sum=1,i=1;
        //int peak,dip;
        while(i<n){
            if(ratings[i]==ratings[i-1]){
                sum++;
                i++;
                continue;
            }
            int peak=1;
            while(i<n && ratings[i]>ratings[i-1]){
                peak++;
                sum+=peak;
                i++;
            }
            int dip=1;
            while(i<n && ratings[i]<ratings[i-1]){
                sum+=dip;
                dip++;
                //sum+=dip;//wrong sequence
                i++;
            } 
            if(dip>peak) sum+= (dip - peak);
        } return sum; 
    }
public static void main(String[] args) {
    CandyProblem cp = new CandyProblem();
    
    // Test cases
    int[] ratings1 = {1, 0, 2};
    int[] ratings2 = {1, 2, 2};
    
    System.out.println(cp.candy(ratings1)); // Output: 5
    System.out.println(cp.candy(ratings2)); // Output: 4
}

}
