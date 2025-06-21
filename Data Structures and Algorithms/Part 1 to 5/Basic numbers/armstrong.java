//q5
// Check if a number is Armstrong Number or not

// Problem Statement: 
// Given an integer N, return true it is an Armstrong number otherwise return false.

// An Amrstrong number is a number that is equal to 
// the sum of its own digits each raised to the power of the number of digits.

import java.util.Scanner;
public class armstrong {

    int n;

    armstrong(int num){
        n = num;
    }

    public void check(){

        int d = 0;
        for(int i = n; i>0; i/=10){
            d++;
        }

        int comp = 0;

        for(int i = n; i>0; i/=10){
            comp += Math.pow((i%10),d);
        }

        if(comp == n)
            System.out.println("No. is armstrong");
        else
            System.out.println("No. is not armstrong.");

    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Inter a number: ");
        int num = sc.nextInt();
        sc.close();
        armstrong obj= new armstrong(num);
        obj.check();

    }
    
}
