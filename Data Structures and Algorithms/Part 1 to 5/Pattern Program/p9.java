/* P9
    *
   ***
  *****
   ***
    *
 using iteration & recursion
*/

import java.util.Scanner;

public class p9 {

    public static void printPatternR1(int rows,int currentRow,int same) {
        if (currentRow > rows)
            return;

            int Ngap;
        //print gaps row - currentRow +1(extra 1 gap for transition) times
        if(same==0) Ngap=rows - currentRow + 1;
        else Ngap=rows - currentRow;
        for(int i = 0; i < Ngap; i++) {
            System.out.print(" ");
        }

        //print * 2*currentRow-rows times
        int Nstar=2*currentRow-1;
        for(int i = 0; i < Nstar; i++) {
            System.out.print("*");
        }

        System.out.println();

        // Recursive call with updated currentRow
        printPatternR1(rows, currentRow + 1,same);
    }

    public static void printPatternR2(int rows,int currentRow) {
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
        printPatternR2(rows, currentRow + 1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = s.nextInt();
        //to determine whether rows is even or odd, hence the distribution of work among loops
        int n= rows;
        int n1,n2;
        n1=n/2;
        if(n%2==0) {
            n2=n/2;
        }else{
            n2=n/2+1;
        }
        int gap, star;
        //Iterative implementation 
        System.out.println("Iterative Implementation");
        //1st half subproblem
        if(n1==n2)
        gap=n1;
        else gap=n1+1;
        star=1;
        for(int i=1;i<=n1;i++)
        {
            
                for(int j=1;j<=gap-i;j++)
                {
                    System.out.print(" ");
                }
                for(int k=1;k<=star;k++)
                {
                    System.out.print("*");
                }
                System.out.println();
                
                star=star+2;
        }
        gap=0;
            star=2*n2-1;
        for(int i=1;i<=n2;i++)
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
        FullprintPatternR(rows);
        // char ch=65;
        // System.out.println((char)(ch+1));
        s.close();
    }



    private static void FullprintPatternR(int rows) {
        int n= rows;
        int n1,n2;
        int same=0;
        n1=n/2;
        if(n%2==0) {
            n2=n/2; same=1;
        }else{
            n2=n/2+1;
        }
        
        printPatternR1(n1,1,same);
        printPatternR2(n2,1);
    }
}


