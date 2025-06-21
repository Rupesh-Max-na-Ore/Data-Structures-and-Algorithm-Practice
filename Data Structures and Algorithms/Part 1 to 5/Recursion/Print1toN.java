/*
 q1 and q3 (they are same really)
 Print nos. from 1 to n using Recursion
 */

import java.util.*;
public class Print1toN{

    protected int n;

    Print1toN(int num){
        n=num;
        PrintCount(1,n);
    }
    public static void PrintCount(int i,int n){
        if(i>n) return;
        System.out.println(i);
        PrintCount(i+1,n);
    }

    
public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.print("Enter a no. as input:");
    int n=s.nextInt();
    Print1toN CD= new Print1toN(n);
    
    s.close();
}

}