/* P16
A
BB
CCC
DDDD
EEEEE
 using iteration & recursion(do later)
*/

import java.util.Scanner;

public class p16 {
    public static void main(String[] args) {
        
    
    Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = s.nextInt();
        char ch='A';
        int i,j;
        for(i=0;i<n;i++)
        {   
            
            for(j=0;j<=i;j++)
            {
                //System.out.print((char)(ch+j));
                System.out.print(ch);
            }System.out.println();ch++;
        }
    }
}
