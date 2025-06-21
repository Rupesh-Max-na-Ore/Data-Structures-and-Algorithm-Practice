//q4
//Problem: Print from N to 1 using Recursion

import java.util.Scanner;

public class PrintNto1 {
    protected int n;

    PrintNto1(int num){
        n=num;
        System.out.println("Starting to print "+n+" times: ");
        PrintCount(1,n);
    }
    public static void PrintCount(int i,int n){
        if(i>n) return;
        
        PrintCount(i+1,n);

        System.out.println(i);
    }

    
public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.print("Enter a no. as input:");
    int n=s.nextInt();
    PrintNto1 CD= new PrintNto1(n);
    
    s.close();
}}
