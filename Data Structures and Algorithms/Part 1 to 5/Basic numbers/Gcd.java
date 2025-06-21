// q4

// Find GCD of two numbers

// Problem Statement: Given two integers N1 and N2, find their greatest common divisor.

// The Greatest Common Divisor of any two integers is the largest number that divides both integers.

import java.util.Scanner;

public class Gcd {
    public static int calcGcd(int a, int b) {
        while(a > 0 && b > 0) {
            if(a > b) {
                a=a-b;
                //as good as a = a % b;
            }  else {
                b=b-a;
                //equivalent to b = b % a;
           }
        }
        if(a == 0) {
            return b;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter value for n1 & n2: ");
        int n1=s.nextInt(); int n2=s.nextInt();
        int gcd = calcGcd(n1, n2);
        System.out.println("GCD of " + n1 + " and " + n2 + " is: " + gcd); s.close();
    }
}
