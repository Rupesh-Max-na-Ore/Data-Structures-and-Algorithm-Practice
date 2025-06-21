/* P21
Enter the number of rows: 7
*******
*     *
*     *
*     *
*     *
*     *
*******
 using iteration & recursion(do later)
*/

import java.util.Scanner;

public class p21 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = s.nextInt();
        int Ngap1=0;
        int Ngap2=n-2;
        int i,j;
        for(i=1;i<=n;i++)
        {
            if(i==1||i==n){
                for(j=1;j<=n;j++) System.out.print("*");
                
            }
            else{
                System.out.print("*");
                for(j=1;j<=Ngap2;j++) System.out.print(" ");
                System.out.print("*");
            }System.out.println();
        }
    }
    
}
