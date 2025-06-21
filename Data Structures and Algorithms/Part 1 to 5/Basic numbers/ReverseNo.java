//q2

// Reverse a number 

// Problem Statement: Given a number N reverse the number and print it.

import java.util.Scanner;

public class ReverseNo {
    protected int n;
    // protected int r=0;
    // protected int t=0;

    ReverseNo(int num){
        n=num;
        
    }

    public int actuallyRev(){
        //Same way
        // while(num>0){
        //     t=num%10;
        //     r=r*10+t;
        //     num=num/10;
        // }
        // return r;
        int dig = 0;
        int rev = 0;
        while(n!=0){

            dig = n%10;
            rev *= 10;
            rev += dig;
            n /= 10;

        }

        return rev;

    }
    


    

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter value for n: ");
        int n=s.nextInt();
        System.out.print("Reverse of "+n+"=");
        ReverseNo rev=new ReverseNo(n);
        int reverse= rev.actuallyRev();
        System.out.print(reverse);
         s.close();
    }


    
}
