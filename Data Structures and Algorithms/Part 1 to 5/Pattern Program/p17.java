/* P17
    A
   ABA
  ABCBA
 ABCDCBA
ABCDEDCBA
 using iteration & recursion(do later)
*/

import java.util.Scanner;

public class p17 {
    public static void main(String[] args) {
        
    
    Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = s.nextInt();
        char ch=64;
        int i,j,k,l;
        for(i=1;i<=n;i++)
        {   
            ch=65;
            
            for(j=1;j<=n-i;j++)
            {
                System.out.print(" ");
            }
            for(k=1;k<=(i);k++)
            {
                System.out.print(ch);
                ++ch;
            }--ch;
            for(l=1;l<=i-1;l++)
            {
                System.out.print(--ch);
            }
            System.out.println();
        }
    }
    
}
