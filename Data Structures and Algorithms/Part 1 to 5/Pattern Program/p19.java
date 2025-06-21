/* P19
Enter the number of rows: 5
**********
****  ****
***    ***
**      **
*        *
*        *
**      **
***    ***
****  ****
**********

 using iteration & recursion(do later)
*/

import java.util.Scanner;

public class p19 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = s.nextInt();
        int Nstar1=n;
        int Nstar2=n;
        int Ngap=0;
        int i,j,k,l;
        //Upper Half
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=Nstar1;j++) System.out.print("*");
            for(k=1;k<=Ngap;k++) System.out.print(" ");
            for(l=1;l<=Nstar2;l++) System.out.print("*");
            System.out.println();
            Nstar1--;Nstar2--;
            Ngap=Ngap+2; 
        }

        //Lower Half
        Ngap=2*(n-1);
        Nstar1=i;
        Nstar2=i;

        for(i=1;i<=n;i++)
        {
            for(j=1;j<=i;j++) System.out.print("*");
            for(k=1;k<=Ngap;k++) System.out.print(" ");
            for(l=1;l<=i;l++) System.out.print("*");
            System.out.println();
            Ngap=Ngap-2; 
        }
    }
}
