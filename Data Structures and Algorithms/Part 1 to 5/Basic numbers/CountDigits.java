//q1

// Count digits in a number

// Problem Statement: Given an integer N, return the number of digits in N.
import java.util.*;
public class CountDigits{
    protected int digitCount=0;
    protected int n;

    CountDigits(int n){
        this.n=n;
        while(n>0){
            n=n/10;
            digitCount++;
        }}
    public void PrintNoOfDigits(){
        System.out.println("No. of digits= "+digitCount);
    }

    
public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.print("Enter a no. as input:");
    int n=s.nextInt();
    CountDigits CD= new CountDigits(n);
    CD.PrintNoOfDigits();
    s.close();
}

}