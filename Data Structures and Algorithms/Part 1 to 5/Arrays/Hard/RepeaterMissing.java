package Arrays.Hard;
// //q9
// Find the repeating and missing numbers


// 32

// 0
// Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

// Examples
// Example 1:
// Input Format
// :  array[] = {3,1,2,5,3}
// Result
// : {3,4)
// Explanation
// : A = 3 , B = 4 
// Since 3 is appearing twice and 4 is missing

// Example 2:
// Input Format
// : array[] = {3,1,2,5,4,6,7,5}
// Result
// : {5,8)
// Explanation
// : A = 5 , B = 8 
// Since 5 is appearing twice and 8 is missing

public class RepeaterMissing {
    // applying idea 4
    public static int[] findMissingRepeatingNumbers(int a[], int n) {
        int g=n*(n+1)/2; int s=0;
        int c=1; int p=1;
        for (int i=0;i<n;i++){
            c*=(i+1);
            s+=a[i];
            p*=a[i];
        }
        int y=p*(g-s)/(c-p); //repeating elem
        int x=g-s+y; //missing elem

        int[]b={y,x};
        return b;
    }
// idea 5
    public static int[] findTwoElement(int a[], int n) {
        long s=0; long i=0; long g=n*(n+1)/2; long q=g*(2*n+1)/3;
        for(int j=0;j<n;j++){
            s+=a[j];
            i+=(long)a[j]*a[j];
        }
        long v1=g-s;
        long v3=q-i;
        long v4= v3/v1;
        int x= (int) ((v1+v4)/2);//Missing
        int y= (int) ((v4-v1)/2);//Repeater
        int[] b={y,x};
        return b;
    }
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans1 = findMissingRepeatingNumbers(a,a.length);
        System.out.println("The repeating and missing numbers are: {"
                           + ans1[0] + ", " + ans1[1] + "}");
    }


}

// gfg submission 1
// fails because n can be as big as 10^5 and even 100! exeeds long
// int[] findTwoElement(int a[], int n) {
//     long  g=n*(n+1)/2; long  s=0;
//     long  c=1; long  p=1;
//     for (int i=0;i<n;i++){
//         c*=(i+1);
//         s+=a[i];
//         p*=a[i];
//     }
//     long  y=(p*(g-s)/(c-p)); //repeating elem
//     long  x=(g-s+y); //missing elem

//     int[]b={(int)y,(int)x};
//     return b;

// }

//gfg submissions 2, passed 330/340 TCs
// int[] findTwoElement(int a[], int n) {
//     long s=0; long i=0; long g=n*(n+1)/2; long q=g*(2*n+1)/3;
//     for(int j=0;j<n;j++){
//         s+=a[j];
//         i+=(long)a[j] * (long)a[j];
//     }
//     long v1=g-s;
//     long v3=q-i;
//     long v4= v3/v1;
//     int x= (int) ((v1+v4)/2);//Missing
//     int y= (int) ((v4-v1)/2);//Repeater
//     int[] b={y,x};
//     return b;

// }

//gfg submission 3, xor soln idea 6
// int[] findTwoElement(int a[], int n) {
//     int xor = 0;

//     // XOR all array elements and numbers from 1 to n
//     for (int i = 0; i < n; i++) {
//         xor ^= a[i];
//     }
//     for (int i = 1; i <= n; i++) {
//         xor ^= i;
//     }

//     // Get the rightmost set bit in xor
//     int set_bit_no = xor & ~(xor - 1);

//     // Initialize missing and repeating numbers
//     int x = 0, y = 0;

//     // Divide elements into two sets by comparing the rightmost set bit
//     // and perform XOR in both sets
//     for (int i = 0; i < n; i++) {
//         if ((a[i] & set_bit_no) != 0) {
//             x ^= a[i];
//         } else {
//             y ^= a[i];
//         }
//     }
//     for (int i = 1; i <= n; i++) {
//         if ((i & set_bit_no) != 0) {
//             x ^= i;
//         } else {
//             y ^= i;
//         }
//     }

//     // Determine which is the missing number and which is the repeating one
//     int missing = 0, repeating = 0;
//     for (int i = 0; i < n; i++) {
//         if (a[i] == x) {
//             repeating = x;
//             missing = y;
//             break;
//         } else if (a[i] == y) {
//             repeating = y;
//             missing = x;
//             break;
//         }
//     }

//     int[] result = {repeating, missing};
//     return result;
// }
