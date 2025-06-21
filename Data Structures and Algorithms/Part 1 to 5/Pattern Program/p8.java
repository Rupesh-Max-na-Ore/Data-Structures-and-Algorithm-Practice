/* P8
    *
   ***
  *****
 *******
*********
 using iteration & recursion
*/

import java.util.Scanner;

public class p8 {

    public static void printPatternR(int rows,int currentRow) {
        if (currentRow > rows)
            return;

        
        //print gaps currentRow-1 times
        int Ngap=currentRow-1;
        for(int i = 0; i < Ngap; i++) {
            System.out.print(" ");
        }

        //print * 2*(rows-currentRow)+1 times
        int Nstar=2*(rows-currentRow)+1;
        for(int i = 0; i < Nstar; i++) {
            System.out.print("*");
        }

        System.out.println();

        // Recursive call with updated currentRow
        printPatternR(rows, currentRow + 1);
    }

   

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = s.nextInt();
        int gap, star;
        //Iterative Fn use
        System.out.println("Iterative Implementation");
        gap=0;
            star=2*rows-1;
        for(int i=1;i<=rows;i++)
        {
            
                for(int j=1;j<=gap;j++)
                {
                    System.out.print(" ");
                }
                for(int k=1;k<=star;k++)
                {
                    System.out.print("*");
                }
                System.out.println();
                gap++;
                star=star-2;
        }

        // Recursive Fn call
        System.out.println("Recursive Implementation");
        printPatternR(rows,1);

        s.close();
    }
}


