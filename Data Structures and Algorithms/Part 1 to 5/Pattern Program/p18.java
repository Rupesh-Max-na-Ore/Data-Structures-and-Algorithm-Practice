/* P16
Enter the number of rows: 5
E
DE
CDE
BCDE
ABCDE
 using iteration & recursion(do later)
*/

import java.util.Scanner;

public class p18 {
    public static void main(String[] args) {
        
    
    Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = s.nextInt();
        char ch='A';
        int i,j;
        int UL=n;
        int LL=n-1;
        for(i=1;i<=n;i++)
        {   
            LL=UL-i;
            while(LL<UL)
            {
                System.out.print((char)(ch+LL));
                LL++;
            }System.out.println();
        }
    }
}
