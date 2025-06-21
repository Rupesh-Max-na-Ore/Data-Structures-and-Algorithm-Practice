//q6
// Print all Divisors of a given Number

// Problem Statement: Given an integer N, return all divisors of N.
// A divisor of an integer N is a positive integer that divides N without leaving a remainder. In other words, 
// if N is divisible by another integer without any remainder, then that integer is considered a divisor of N.

import java.util.Scanner;
public class Divisors {
    int n;

    Divisors(int num){
        n = num;
    }

    public int[] making_khappe(){

        int val = (int)Math.sqrt(n);
        int div[] = new int[val];
        int ind =0;
        for(int i = 1; i<=val; i++){
            if(n%i==0){
                div[ind] = i;
                div[ind+1] = n/i;
                ind++; 
            }

        }
        if(val*val == n)
            div[ind-1]=0;
        return div;

    }

    public void serving_khappe(int[] a){

        for(int i = 0; i<a.length; i++){
            if(a[i] != 0)
            System.out.print(a[i] + " , ");
    
        }
    }
    public static void exec(int k){
        Divisors obj = new Divisors(k);
        obj.serving_khappe(obj.making_khappe());
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        sc.close();
        exec(w);
    }

}
