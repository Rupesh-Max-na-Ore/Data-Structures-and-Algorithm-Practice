/* P14
A
AB
ABC
ABCD
ABCDE
 using iteration & recursion(do later)
*/

import java.util.Scanner;

public class p14 {
    public static void main(String[] args) {
        
    
    Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = s.nextInt();
        char ch=65;
        int i,j;
        for(i=0;i<n;i++)
        {   
            ch=65;
            for(j=0;j<=i;j++)
            {
                //System.out.print((char)(ch+j));
                System.out.print(ch++);
            }System.out.println();
        }
    }
}
