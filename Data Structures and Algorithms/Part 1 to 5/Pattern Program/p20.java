/* P20
Enter the number of rows: 5
*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *

 using iteration & recursion(do later)
*/

import java.util.Scanner;

public class p20 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = s.nextInt();
        int Ngap=2*(n-1);
        int i,j,k,l;
        //Upper Half
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=i;j++) System.out.print("*");
            for(k=1;k<=Ngap;k++) System.out.print(" ");
            for(l=1;l<=i;l++) System.out.print("*");
            System.out.println();
            Ngap=Ngap-2; 
        }

        Ngap=2;//Lower Half

        for(i=n-1;i>=1;i--)
        {
            for(j=1;j<=i;j++) System.out.print("*");
            for(k=1;k<=Ngap;k++) System.out.print(" ");
            for(l=1;l<=i;l++) System.out.print("*");
            System.out.println();
            Ngap=Ngap+2; 
        }
    }
}
