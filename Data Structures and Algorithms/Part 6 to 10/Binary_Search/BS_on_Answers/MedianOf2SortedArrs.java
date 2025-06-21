package Binary_Search.BS_on_Answers;
/*Q12
 * Median of Two Sorted Arrays of different sizes

Problem Statement: Given two sorted arrays arr1 and arr2 of size m and n respectively, return the median of the two sorted arrays. The median is defined as the middle value of a sorted list of numbers. In case the length of the list is even, the median is the average of the two middle elements.

Examples
Example 1:
Input Format:
 n1 = 3, arr1[] = {2,4,6}, n2 = 3, arr2[] = {1,3,5}
Result:
 3.5
Explanation:
 The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 5, 6 }. As the length of the merged list is even, the median is the average of the two middle elements. Here two medians are 3 and 4. So the median will be the average of 3 and 4, which is 3.5.

Example 2:
Input Format:
 n1 = 3, arr1[] = {2,4,6}, n2 = 2, arr2[] = {1,3}
Result:
 3
Explanation:
 The array after merging 'a' and 'b' will be { 1, 2, 3, 4, 6 }. The median is simply 3.


 * 
 */
public class MedianOf2SortedArrs {
    public double findMedianSortedArrays(int[] a, int[] b) {

        int n=a.length; int m=b.length;
        if(n>m) return findMedianSortedArrays(b, a); // apply algo on shorter array to reduce search space in BinSrch and TC
        int nn=n+m;// total length of merged array
        int lhl=(nn+1)/2; // left half length
        /* Ini Range for BinSrch */
        int l=0; int r=n;
        
        while(r>=l){
            int m1=l+(r-l)/2; // left cut for array1
            int m2=lhl-m1; // left cut for array2
            /* Calc elems for cross check */ 
            double l1,l2,r1,r2;
            l1=(m1>0)?a[m1-1]:Integer.MIN_VALUE;
            l2=(m2>0)?b[m2-1]:Integer.MIN_VALUE;
            r1=(m1<n)?a[m1]:Integer.MAX_VALUE;
            r2=(m2<m)?b[m2]:Integer.MAX_VALUE;
            /*Cross Check */
            if((l1<=r2)&&(l2<=r1)){
                if(nn%2==0) {
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                } else return Math.max(l1,l2)/1.0;
            }
            else if(l1>r2) r=m1-1; // took too many elems from a1 in left half
            else if(l2>r1) l=m1+1; // took too many elems from a1 in right half
        } return 0; 
    }
    public static void main(String[] args) {
        MedianOf2SortedArrs medianFinder = new MedianOf2SortedArrs();
        
        // Test cases
        int[] arr1 = {2, 4, 6};
        int[] arr2 = {1, 3, 5};
        System.out.println("Test Case 1:");
        System.out.println("Input: arr1 = {2, 4, 6}, arr2 = {1, 3, 5}");
        System.out.println("Output: " + medianFinder.findMedianSortedArrays(arr1, arr2)); // Expected output: 3.5

        int[] arr3 = {2, 4, 6};
        int[] arr4 = {1, 3};
        System.out.println("\nTest Case 2:");
        System.out.println("Input: arr1 = {2, 4, 6}, arr2 = {1, 3}");
        System.out.println("Output: " + medianFinder.findMedianSortedArrays(arr3, arr4)); // Expected output: 3.0

        // Large inputs test
        int size = 1000000;
        int[] largeArr1 = new int[size];
        int[] largeArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            largeArr1[i] = 2 * i;
            largeArr2[i] = 2 * i + 1;
        }
        System.out.println("\nLarge Input Test Case:");
        System.out.println("Output: " + medianFinder.findMedianSortedArrays(largeArr1, largeArr2)); // Expected output will be size - 0.5
    }
}

/*
 * LC Optimized code submisiion
 * class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n=a.length; int m=b.length;
        if(n>m) return findMedianSortedArrays(b, a); // apply algo on shorter array to reduce search space in BinSrch and TC
        int nn=n+m;// total length of merged array
        int lhl=(nn+1)/2; // left half length
        int l=0; int r=n;
        
        while(r>=l){
            int m1=l+(r-l)/2; // left cut for array1
            int m2=lhl-m1; // left cut for array2
            double l1,l2,r1,r2;
            l1=(m1>0)?a[m1-1]:Integer.MIN_VALUE;
            l2=(m2>0)?b[m2-1]:Integer.MIN_VALUE;
            r1=(m1<n)?a[m1]:Integer.MAX_VALUE;
            r2=(m2<m)?b[m2]:Integer.MAX_VALUE;
            //Cross Check 
            if((l1<=r2)&&(l2<=r1)){
                double max = (l1>l2)? l1:l2;
                double min = (r1<r2)? r1:r2;
                if(nn%2==0) {
                    return (max+min)/2.0;
                } else return max;
            }
            else if(l1>r2) r=m1-1; // took too many elems from a1 in left half
            else if(l2>r1) l=m1+1; // took too many elems from a1 in right half
        } return 0; 
    }
}
 * 
 */