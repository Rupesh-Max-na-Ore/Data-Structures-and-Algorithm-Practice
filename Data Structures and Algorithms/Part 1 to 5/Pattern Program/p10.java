/* P10
*
**
***
**
*
 using iteration & recursion
*/

import java.util.Scanner;

public class p10 {

    public static void printPatternRu(int rows) {
        if (rows == 0)
            return;

        

        // Recursive call with rows - 1
        printPatternRu(rows - 1);

        // Print '*' 'rows' number of times
        printStarsU(1, rows);
        System.out.println();
    }

    public static void printStarsU(int current, int target) {
        if (current > target)
            return;
        System.out.print("*");
        printStarsU(current + 1, target);
    }

    public static void printPatternRl(int rows) {
        if (rows == 0)
            return;

        // Print '*' 'rows' number of times
        printStarsL(1, rows);
        System.out.println();

        // Recursive call with rows - 1
        printPatternRl(rows - 1);
    }

    public static void printStarsL(int current, int target) {
        if (current > target)
            return;
        System.out.print("*");
        printStarsL(current + 1, target);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = s.nextInt();

        int n2=Math.ceilDiv(rows,2);
        int n1=rows/2;
        int n3;
        if(n1%2==0) n3=n1;
        else n3=n1+1;

        System.out.println("Iterative Implementation");
        for(int i=0;i<n3;i++)
        {
                for(int j=0;j<=i;j++)
                {
                    System.out.print("*");
                }
                System.out.println();
        }
        for(int i=n2;i>=1;i--)
        {
                for(int j=1;j<=i;j++)
                {
                    System.out.print("*");
                }
                System.out.println();
        }

        //Iterative Fn use
        // gives this 
        // *
        // **
        // ***
        // ***
        // **
        // *  for n=6(even)
        // System.out.println("Iterative Implementation");
        // for(int i=0;i<n1;i++)
        // {
        //         for(int j=0;j<=i;j++)
        //         {
        //             System.out.print("*");
        //         }
        //         System.out.println();
        // }
        // for(int i=n2;i>=1;i--)
        // {
        //         for(int j=1;j<=i;j++)
        //         {
        //             System.out.print("*");
        //         }
        //         System.out.println();
        // }
        System.out.println("Recursive Implementation");
        //n2 &n3 placement interchangeable here
        printPatternRu(n2);
        printPatternRl(n3);
        // Recursive Fn call
        // System.out.println("Recursive Implementation");
        // printPatternRu(n1);
        // printPatternRl(n2);

        s.close();
    }
}

