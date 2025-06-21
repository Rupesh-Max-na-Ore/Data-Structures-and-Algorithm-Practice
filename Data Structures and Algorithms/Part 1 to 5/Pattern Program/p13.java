/* P13
1
23
456
78910
1112131415
 using iteration & recursion(do later)
*/

import java.util.Scanner;

public class p13 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = s.nextInt();
        int count=1;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(count);
                count++;
            }System.out.println();
        }
    }
    
}
