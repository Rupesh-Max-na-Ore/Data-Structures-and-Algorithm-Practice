package Trie.Lec2_Problems;

import java.util.Scanner;

public class q5_Bit_Prerequisities {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a no.: ");
        int n = sc.nextInt();
        System.out.println("Enter a bit to Set: ");
        int x = sc.nextInt();
        //CHeck if x th bit set or not
        if(((1<<x)&n) == 0){
            //if not set, set it, return new no.
            System.out.println(x+"th bit  not set.");
            int new_n = (1<<x)|n;
            System.out.println("On setting it new no. is = "+ new_n);
            System.out.println("Old number in binary: " + Integer.toBinaryString(n));
            System.out.println("New number in binary: " + Integer.toBinaryString(new_n));
        }else{//if it is set, no need to do anything
            System.out.println(x+"th bit  is already set.");
            System.out.println("Old number in binary: " + Integer.toBinaryString(n));
            System.out.println("New number in binary: " + Integer.toBinaryString(n));
        }
    }
}
