/* P12
1      1
12    21
123  321
12344321
 using iteration & recursion(do later)
*/

import java.util.Scanner;

public class p12 {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = s.nextInt();
        int Ngap1,Ngap2,N1=1,N2=1,i=1,j=1,k=1,l=1,m=1;
        Ngap1=n-1;
        Ngap2=Ngap1;


        //Iterative soln
        System.out.println("Iterative Implementation");
        while(i<=n)
        {
            j=1;k=1;l=1;m=1;
            while(j<=N1) {System.out.print(j);j++;}
            while(k<=Ngap1) {System.out.print(" ");k++;}
            while(l<=Ngap2) {System.out.print(" ");l++;}
            while(m<=N2) {System.out.print(N2-m+1);m++;}
            System.out.println();
            N1++;N2++;Ngap1--;Ngap2--;i++;

        }

        

        s.close();
    }
}


