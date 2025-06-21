package Greedy_Algorithms.Easy;

import java.util.ArrayList;
import java.util.Arrays;

/*Q3 Find minimum number of coins


22

51
Problem Statement: Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the denominations in Indian currency, i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum number of coins and/or notes needed to make the change.

Examples:

Example 1:

Input: V = 70

Output: 2

Explaination: We need a 50 Rs note and a 20 Rs note.

Example 2:

Input: V = 121

Output: 3

Explaination: We need a 100 Rs note, a 20 Rs note and a 1 Rs coin. */
public class Minimum_no_of_coins {
    
    public int MinNoOfCoinChange(int currency[], int n, int v){
        Arrays.sort(currency);
        int cnt=0;
        ArrayList <Integer> change = new ArrayList <>();
        for(int i=n-1;i>=0;i--){
            while (currency[i]<=v) {
                v-=currency[i];
                cnt++;
                change.add(currency[i]);
            }
            if(v==0) break;//optimization
        }
        return cnt;
    }
}
