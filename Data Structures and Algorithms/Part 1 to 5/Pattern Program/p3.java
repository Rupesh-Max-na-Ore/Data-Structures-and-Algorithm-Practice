/* P3
1
12
123
1234
12345
 using iteration & recursion
*/

import java.util.Scanner;

public class p3 {

    public static void printPatternR(int rows) {
        if (rows == 0)
            return;

        

        // Recursive call with rows - 1
        printPatternR(--rows);

        // Print '*' 'rows' number of times
        printStars(0, rows);
        System.out.println();
    }

    public static void printStars(int current, int target) {
        if (current == target)
            return;
        System.out.print(current+1);
        printStars(++current, target);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = s.nextInt();

        //Iterative Fn use
        System.out.println("Iterative Implementation");
        for(int i=0;i<rows;i++)
        {
                for(int j=0;j<=i;j++)
                {
                    System.out.print(j+1);
                }
                System.out.println();
        }

        // Recursive Fn call
        System.out.println("Recursive Implementation");
        printPatternR(rows);

        s.close();
    }
}


