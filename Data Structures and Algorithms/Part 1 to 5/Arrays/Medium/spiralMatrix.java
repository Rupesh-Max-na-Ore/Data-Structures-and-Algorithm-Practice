package Arrays.Medium;
//q13
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class spiralMatrix {

    //lc needs arraylist return, hence not just using array like in my pseudocode in notes

    public static List<Integer> spiralOrder(int[][] a) {
        int n=a.length; int m= a[0].length;
        List<Integer> B=new ArrayList<>();
        int t=0;int r=m-1; int b=n-1; int l=0; int i,j;
        while(t<=b && l<=r){
            //t th row
            for(i=l;i<=r;i++){
                B.add(a[t][i]);
            } t++;
            //r th col
            for(i=t;i<=b;i++){
                B.add(a[i][r]);
            } r--;

            //
            if(t<=b){
                //b th row
                for(i=r;i>=l;i--){
                    B.add(a[b][i]);
                } b--;
            }

            //
            if(l<=r){
                //l th col
                for(i=b;i>=t;i--){
                    B.add(a[i][l]);
                } l++;
            }   
        }return B;
    }


        public static void main(String[] args) {
        int [][] A={{0,1,2},{4,5,6},{8,9,-99}};
        // Print the 2D array using Arrays.deepToString
        System.out.println(Arrays.deepToString(A));
        // System.out.println(Arrays.toString(A));
        List<Integer> B= spiralMatrix.spiralOrder(A);
        // System.out.println(Arrays.toString(A));
        // abpve not work
        // Print the 2D array using Arrays.deepToString
        System.out.println(B);
    }

}
//lc submission
// class Solution {
//     public List<Integer> spiralOrder(int[][] a) {
//         int n=a.length; int m= a[0].length;
//         List<Integer> B=new ArrayList<>();
//         int t=0;int r=m-1; int b=n-1; int l=0; int i,j;
//         while(t<=b && l<=r){
//             //t th row
//             for(i=l;i<=r;i++){
//                 B.add(a[t][i]);
//             } t++;
//             //r th col
//             for(i=t;i<=b;i++){
//                 B.add(a[i][r]);
//             } r--;

//             //
//             if(t<=b){
//                 //b th row
//                 for(i=r;i>=l;i--){
//                     B.add(a[b][i]);
//                 } b--;
//             }

//             //
//             if(l<=r){
//                 //l th col
//                 for(i=b;i>=t;i--){
//                     B.add(a[i][l]);
//                 } l++;
//             }   
//         }return B;
//     }
// }