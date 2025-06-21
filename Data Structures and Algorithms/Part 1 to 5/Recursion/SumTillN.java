//q5
//Problem:sum terms from 1 to N using Recursion

import java.util.Scanner;

public class SumTillN {
    protected int n;

    SumTillN(int num){
        n=num;
        int accum=0;
        System.out.println("Starting to accumulate "+n+" times: ");
        Sum(1,n, accum);
    }
    public static void Sum(int i,int n, int accum){
        if(i>n) {System.out.println("Sum till "+n+" ="+accum);
            return;}
        accum+=i;
        Sum(i+1,n,accum);

        
    }

    
public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.print("Enter a no. as input:");
    int n=s.nextInt();
    SumTillN CD= new SumTillN(n);
    
    s.close();
}}
