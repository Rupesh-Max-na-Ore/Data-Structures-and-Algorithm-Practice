//q3

// Check if a number is Palindrome or Not

// Problem Statement: Given an integer N, return true if it is a palindrome else return false.

// A palindrome is a number that reads the same backward as forward. 
// For example, 121, 1331, and 4554 are palindromes because they remain the same when their digits are reversed.

// Enter a no.: 7667
// Enter a string: ruppur

// Yes, string is Palindrome
// Yes, no. is Palindrome

// Enter a no.: 111
// Enter a string: loooj
// No, string ain't Palindrome
// Yes, no. is Palindrome

import java.util.*;
public class Palindrome {
    int n;
    String str;
    Palindrome(int num){
        n=num;
    }
    Palindrome(String s){
        str=s;
    }
    //First attempt
    // public boolean IntCheckPalindrome(){
    //     int i1,i2;
    //     int length=0;
    //     int N=n;
    //     while(N>0){
    //         N=N/10; length++;
    //     }int odd;
    //     if(length%2==0) {i1=length/2; odd=0;} 
    //     else {i1=length/2; odd=1;}

    //     //Reverse half of no. from backwards direction
    //     int dig = 0;
    //     int hrev = 0;
    //     int n1=n;
    //     for(i2=0;i2<=i1;i2++){

    //         dig = n1%10;
    //         hrev *= 10;
    //         hrev += dig;
    //         n1 /= 10;
    //         System.out.println("Half rev= " +hrev);

    //     }if(odd==1) n1/=10;


    //     if(n1==hrev) {
    //         return true;
    //     }else{return false;}

    // }

    //optimized attempt
    public boolean IntCheckPalindrome() {
        int length = 0;
        int N = n;
        while (N > 0) {
            N = N / 10;
            length++;
        }
    
        int i1 = length / 2;
        int odd;
        if(length%2==0) { odd=0;} 
         else {odd=1;}
        int n1 = n;
        int hrev = 0;
        for (int i2 = 0; i2 < i1; i2++) {
            int dig = n1 % 10;
            hrev = hrev * 10 + dig;
            n1 /= 10;
        } if(odd==1) n1/=10;
    
        return n1 == hrev;
    }
    
    //FIrst attempt
    // public boolean StringCheckPalindrome(){
    //     int len=str.length(); int n2;int i; int odd;int br=0;
    //     if (len%2==0){n2=len/2;odd=0;}
    //     else{n2=len/2;odd=1;}
    //     for (i=0;i<=n2;i++)
    //     {
    //         if(str.charAt(i)==str.charAt(n2-i-1)) continue;
    //         else {br=1;break;}
    //     }
    //     if(br==1) return false;
    //     else return true;
    // }
    //Optimized attempt
    public boolean StringCheckPalindrome() {
        int len = str.length();
        int n2 = len / 2;
        for (int i = 0; i < n2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
    

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a no.: ");
        int n=sc.nextInt();
        sc.nextLine();   
        System.out.print("Enter a string: ");
        String string=sc.nextLine();
        

        Palindrome p=new Palindrome(string);
        Palindrome pp=new Palindrome(n);

        boolean pt = p.StringCheckPalindrome();
        boolean ppt=pp.IntCheckPalindrome();

        if(pt==true){
            System.out.println("Yes, string is Palindrome");
        }else{
            System.out.println("No, string ain't Palindrome");
        }

        if(ppt==true){
            System.out.println("Yes, no. is Palindrome");
        }else{
            System.out.println("No, no. given ain't Palindrome");
        }
        sc.close();

    }

    
}
