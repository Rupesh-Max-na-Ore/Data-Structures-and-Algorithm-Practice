/* P1
*****
*****
*****
*****
*****
 using iteration & recursion
*/

import java.util.Scanner;

public class p1 {

    public static void printPattern(int rows, int cols)
    {
        //Loop for rows
        for(int i=0; i<rows;i++)
        {   
            //Loop for cols.
            // to Print '*' cols no. of times
            for(int j=0;j<cols;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    

    public static void printPatternR(int rows, int cols) {
        //Base case- when rows becomes 0, stop recursion
        if (rows == 0)
            return;
        
        
        // Print '*' cols no. of times
        for (int i = 0; i < cols; i++) {
            System.out.print("*");
        }
        System.out.println();

        //Recursive case
        //Recursive call with rows - 1
        printPatternR(rows - 1, cols);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows and columuns: ");
        int rows = s.nextInt();
        int cols = rows; 
        // as No. of cols is same as rows
        System.out.println("Iterative soln:");
        printPattern(rows, cols);
        // fn call
        System.out.println("Recursive soln:");
        printPatternR(rows, cols);

        s.close();
    }
}