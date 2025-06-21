/*
 q2
 Print string n times using Recursion
 */


import java.util.Scanner;

public class PrintNameNtimes {
    
    public PrintNameNtimes(int num,String str) {
        int n=num;
        System.out.println("Starting to Print "+n+" times:");
        PrintNameCount(1,n,str);
    }
    public static void PrintNameCount(int i,int n,String str){
        if(i>n) return;

        System.out.println(str);
        PrintNameCount(i+1,n, str);
    }
    public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.print("Enter a no. and String as input:");
    int n=s.nextInt();
    s.nextLine();
    String str=s.nextLine();
    
    PrintNameNtimes CD= new PrintNameNtimes(n,str);
    
    s.close();
}
}
