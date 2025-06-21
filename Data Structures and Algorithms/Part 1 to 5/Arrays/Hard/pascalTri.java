/**
 * Q1
 * Program to generate Pascal's Triangle


55

1
Problem Statement: This problem has 3 variations. They are stated below:

Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.

Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
 */

package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class pascalTri {

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> A = new ArrayList<>();

        //store whole pascal's triangle:
        for (int row = 1; row <= n; row++) {
            //generate each row
            A.add(generateRow(row));
        }
        return A;
    }

    public static List<Integer> generateRow(int row) {
        //generate current row
        long a = 1;
        List<Integer> aRow = new ArrayList<>();
        aRow.add(1); //insert 1st elem

        //calc. the rest of the elems.
        for (int col = 1; col < row; col++) {
            a = a * (row - col);
            a = a / col;
            aRow.add((int)a);
        }
        return aRow;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = pascalTriangle(n);
        for (List<Integer> l : ans) {
            for (int e : l) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
}
}

// //lc submission
// public List<List<Integer>> generate(int n) {
//     List<List<Integer>> A = new ArrayList<>();

//     //store whole pascal's triangle:
//     for (int row = 1; row <= n; row++) {
//         //generate each row
//         A.add(generateRow(row));
//     }
//     return A;
// }

// public List<Integer> generateRow(int row) {
//     //generate current row
//     long a = 1;
//     List<Integer> ansRow = new ArrayList<>();
//     ansRow.add(1); //insert 1st elem

//     //calc. the rest of the elems.
//     for (int col = 1; col < row; col++) {
//         a = a * (row - col);
//         a = a / col;
//         ansRow.add((int)a);
//     }
//     return ansRow;
// }