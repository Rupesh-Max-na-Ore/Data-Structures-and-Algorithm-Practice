package Greedy_Algorithms.Easy;

import java.util.PriorityQueue;

/*Q2 Fractional Knapsack
Difficulty: MediumAccuracy: 32.46%Submissions: 254K+Points: 4
Given weights and values of n items, we need to put these items in a knapsack of capacity w to get the maximum total value in the knapsack. Return a double value representing the maximum value in knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item here. The details of structure/class is defined in the comments above the given function.

Examples :

Input: n = 3, w = 50, value[] = [60,100,120], weight[] = [10,20,30]
Output: 240.000000
Explanation: Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total value becomes 60+100+80.0=240.0 Thus, total maximum value of item we can have is 240.00 from the given capacity of sack. 
Input: n = 2, w = 50, value[] = [60,100], weight[] = [10,20]
Output: 160.000000
Explanation: Take both the items completely, without breaking. Total maximum value of item we can have is 160.00 from the given capacity of sack.
Expected Time Complexity : O(n log n)
Expected Auxilliary Space: O(1)

Constraints:
1 <= n <= 105
1 <= w <= 109
1 <= valuei, weighti <= 104 */
public class Fractional_Knapsack {
    /*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/
    // Correct logic, wrong data types and comparator, below
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        int rate[][]=new int[n][3];
        for(int i=0; i<n;i++){
            rate[i][0]=arr[i].value/arr[i].weight;// this should be double actually, to not loose fractional vals.
            rate[i][1]=arr[i].value;
            rate[i][2]=arr[i].weight;
        }
        PriorityQueue<Integer[]> maxH=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<n;i++){
            maxH.offer(rate[i]);
        }
        int maxV=0;// should be double
        while(w!=0){
            int[] currItem=maxH.poll();// should be double
            if(w-currItem[2]>=0){
                maxV+=currItem[1];// should be double
                w-= currItem[2];// should be double
            }
            else{
                maxV+=currItem[0]*w;// should be double
                w-=w;// should be double
            }
        }
        return maxV;

    }
}
/*
//Reference code with correct way
package Greedy_Algorithms.Easy;

import java.util.PriorityQueue;

public class Fractional_Knapsack {

    static class Item {
        int value, weight;
        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        // PriorityQueue to store items by their value-to-weight ratio in descending order.
        PriorityQueue<Item> maxHeap = new PriorityQueue<>((a, b) -> 
            Double.compare((double) b.value / b.weight, (double) a.value / a.weight)
        );

        // Add all items to the priority queue.
        for (Item item : arr) {
            maxHeap.offer(item);
        }

        // Variable to store the maximum value we can carry in the knapsack.
        double maxValue = 0.0;

        // Process the items in the max heap until the knapsack is full or we run out of items.
        while (w > 0 && !maxHeap.isEmpty()) {
            Item currentItem = maxHeap.poll();
            if (w >= currentItem.weight) {
                // If the remaining weight capacity can fully accommodate the current item.
                maxValue += currentItem.value;
                w -= currentItem.weight;
            } else {
                // If only part of the current item can be accommodated.
                maxValue += ((double) currentItem.value / currentItem.weight) * w;
                w = 0;
            }
        }

        // Return the maximum value we can carry in the knapsack.
        return maxValue;
    }

    public static void main(String[] args) {
        Fractional_Knapsack knapsack = new Fractional_Knapsack();

        // Test case 1
        int n1 = 3;
        int w1 = 50;
        Item[] arr1 = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };
        System.out.println("Maximum value in knapsack = " + knapsack.fractionalKnapsack(w1, arr1, n1));

        // Test case 2
        int n2 = 2;
        int w2 = 50;
        Item[] arr2 = {
            new Item(60, 10),
            new Item(100, 20)
        };
        System.out.println("Maximum value in knapsack = " + knapsack.fractionalKnapsack(w2, arr2, n2));
    }
}
//
 */

 /*//Striver's ref. code
 import java.util.*;
class Item {
  int value, weight;
  Item(int x, int y) {
    this.value = x;
    this.weight = y;
  }
}

class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b) 
    {
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
}
public class solve{
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator()); 
        
        int curWeight = 0; 
        double finalvalue = 0.0; 
        
        for (int i = 0; i < n; i++) {
       
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }
     
            else {
                int remain = W - curWeight;
                finalvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }
     
        return finalvalue;
        
    }
    public static void main(String args[])
    {
        int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is "+ans);
    }
}
 */