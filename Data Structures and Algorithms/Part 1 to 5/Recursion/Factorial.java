//q6 Factorial

import java.util.Scanner;

public class Factorial {
    
    

    Factorial(int num){
        int n=num;
        
        System.out.println("Starting to accumulate "+n+" nos. pdt.: ");
        int accum= Fact(n);
        System.out.println("Factorial of n= "+accum);

    }
    public static int Fact(int n){
        if (n==0) return 1;
        return n*Fact(n-1);

        
    }

    
public static void main(String args[]){
    Scanner s=new Scanner(System.in);
    System.out.print("Enter a no. as input:");
    int n=s.nextInt();
    Factorial CD= new Factorial(n);
    
    s.close();
}
}
