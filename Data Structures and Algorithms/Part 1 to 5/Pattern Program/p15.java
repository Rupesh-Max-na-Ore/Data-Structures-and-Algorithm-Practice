/* P15
ABCDEF
ABCDE
ABCD
ABC
AB
A
 using iteration & recursion(do later)
*/

import java.util.Scanner;

public class p15 {
    
    public static void main(String[] args) {
        
    
    Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = s.nextInt();
        char ch=65;
        int i,j;
        for(i=0;i<n;i++)
        {   
            ch='A';
            for(j=0;j<=n-i-1;j++)
            {
                //System.out.print((char)(ch+j));
                System.out.print(ch++);
            }System.out.println();
        }
    }

    
}
