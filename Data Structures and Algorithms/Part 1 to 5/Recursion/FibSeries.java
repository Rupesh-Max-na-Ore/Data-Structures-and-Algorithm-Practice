//q9 Fibonacci Series


import java.util.Scanner;


public class FibSeries {

    FibSeries(int num){
        int n=num;
        System.out.println("Print Fibonacci Series till "+n+" :");
        FiboSeries(n,num);
    }
    public void FiboSeries(int n,int num){
        //if(n==0) System.out.print(FibTerm(0));
        if(n<0) return;
        FiboSeries(n-1,num);
        if(n!=num)
        System.out.print(FibTerm(n) + ",");
        else System.out.print(FibTerm(n));
    
    }
    
    public int FibTerm(int n){
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        return FibTerm(n-1)+FibTerm(n-2);
    }
    public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.print("Enter a no. as input:");
    int n=s.nextInt();
    FibSeries CD= new FibSeries(n);
    
    s.close();
}
}
