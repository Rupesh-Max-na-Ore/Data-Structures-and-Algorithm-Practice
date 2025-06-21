//q7
// Check if a number is prime or not
// Problem Statement: Given an integer N, check whether it is prime or not. 
// A prime number is a number that is only divisible by 1 and itself and the total number of divisors is 2.

import java.util.Scanner;

public class prime {

    static boolean is_prime(int n){
        
        if(n==2)
            return true;
        for(int i = 2; i<= (int)Math.sqrt(n); i++){   
            if(n%i == 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
         Scanner s=new Scanner(System.in);
        System.out.println("Enter value for n: ");
        int n=s.nextInt();
        System.out.println(is_prime(n)); s.close();
    }

}
