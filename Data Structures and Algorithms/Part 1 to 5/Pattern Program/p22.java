/* P22
Enter the number of rows: 5
555555555
544444445
543333345
543222345
543212345
543222345
543333345
544444445
555555555
 using iteration & recursion(do later)
*/

import java.util.Scanner;

public class p22 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = s.nextInt();
        int i,j;

        //Idea 1 Soln. in My Notebook, simplest, short, but o(n^3)soln and uses matrix, so higher space complexity
        int N=n;
        int size=2*n-1;
        int start=0;
        int finish=size-1;
        int A[][]=new int[size][size];
        System.out.println("Matrix soln.");
        while(N>0)
        {
            for(i=start;i<=finish;i++){
                for(j=start;j<=finish;j++){
                    if(i==start||j==start||i==finish||j==finish){
                        A[i][j]=N;
                    }
                }
            }start++;finish--;N--;
        }
        for(i=0;i<size;i++){
            for( j=0;j<size;j++){
                System.out.print(A[i][j]);}System.out.println();}

        
        //Idea 2 Soln. in My Notebook, shortest code, O(n^2) soln.
        System.out.println("Distance soln.");
        finish=size-1;
        for(i=0;i<size;i++){
            for( j=0;j<size;j++){
                int top = i;
                int bottom = finish - i;
                int right = finish - j;
                int left = j;              
                System.out.print(n- Math.min(Math.min(top,bottom), Math.min(left,right)));
            }System.out.println();
        }
        //Idea 3 Soln. in My Notebook, using composition long code, but O(n^2) soln as well
        System.out.println("Composition soln.");
        //Upper Half
        int Ngap=2*(n-1);
        N=n;
        for(i=n;i>=1;i--){
            for(j=n;j>=i;j--) System.out.print(j);
            for(int k=1;k<=Ngap;k++) System.out.print(N);
            for(int j2=i+1;j2<=n;j2++) System.out.print(j2);
            System.out.println(); 
            N--; Ngap=Ngap-2;
        }
        //Lower Half
        Ngap=1;N=2;
        int g=2;
        for(i=n-1;i>=1;i--){
            for(j=n;j>=g;j--) System.out.print(j);
            for( int k=1;k<=Ngap;k++) System.out.print(N);
            for(int j2=g;j2<=n;j2++) System.out.print(j2);
            System.out.println(); 
            N++; Ngap=Ngap+2;g++;
        }


    }
}
