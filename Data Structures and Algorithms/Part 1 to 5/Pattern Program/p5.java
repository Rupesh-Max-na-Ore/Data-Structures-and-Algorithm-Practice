/* P5
*****
****
***
**
*
 using iteration & recursion
*/

import java.util.Scanner;

public class p5 {

    public static void printPatternR(int rows) {
        if (rows == 0)
            return;

        // Print '*' 'rows' number of times
        printStars(1, rows);
        System.out.println();

        // Recursive call with rows - 1
        printPatternR(rows - 1);
    }

    public static void printStars(int current, int target) {
        if (current > target)
            return;
        System.out.print("*");
        printStars(current + 1, target);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = s.nextInt();

        //Iterative Fn use
        System.out.println("Iterative Implementation");
        for(int i=rows;i>=1;i--)
        {
                for(int j=1;j<=i;j++)
                {
                    System.out.print("*");
                }
                System.out.println();
        }

        // Recursive Fn call
        System.out.println("Recursive Implementation");
        printPatternR(rows);

        s.close();
    }
}


