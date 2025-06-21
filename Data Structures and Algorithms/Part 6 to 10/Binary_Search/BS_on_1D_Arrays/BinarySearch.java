package Binary Search.BS_on_1D_Arrays;
/*Q1
 * Implement Binary Search
 */
public class BinarySearch {
    class Solution {

        public int BinarySearch(int[]a, int k){

            int l=0;
            int r=a.length-1;
            int m=0;// any random ini.
            while(l<=r){
                m=l+(r-l)/2;
                if(a[m]==k) return m;//if elem k found, it's here only
                else if(a[m]<k) l=m+1;
                else if(a[m]>k) r=m-1;
            }
            return -1;// if elem k never found
        }

        public int InterpolationSearch(int[] a, int k) {
            // any interpolation search that passes all TCs
             int l=0;
            int r=a.length-1;
            if(l==r) {
                if (a[l]==k) return l;
                else return -1;
            }
            while (l<=r) 
            {
                if(l==r) {
                if (a[l]==k) return l;
                else return -1;
            }
                int m=l+((k-a[l])/(a[r]-a[l]))*(r-l);
                
                if(a[m]==k) return m;
                if(a[m]<k) l=m+1;
                else r=m-1;
            }
            return -1;
        }
    }
    
}

// // Interpolation search in Made Easy Book, LC submission 4, 0ms
// class Solution {
//     public int search(int[] arr, int x) {
//         int low = 0, high = arr.length - 1;

//         while (low <= high && x >= arr[low] && x <= arr[high]) {
//             // Check if the array has all the same elements in the current range
//             if (arr[high] == arr[low]) {
//                 if (arr[low] == x) {
//                     return low;
//                 } else {
//                     return -1;
//                 }
//             }

//             // Calculate the position using the interpolation formula
//             int pos = low + ((x - arr[low]) * (high - low) / (arr[high] - arr[low]));

//             // Check if the position is within the array bounds
//             if (pos < low || pos > high) {
//                 return -1;
//             }

//             // Check if we have found the element
//             if (arr[pos] == x) {
//                 return pos;
//             }

//             // If x is larger, x is in the upper part
//             if (arr[pos] < x) {
//                 low = pos + 1;
//             }
//             // If x is smaller, x is in the lower part
//             else {
//                 high = pos - 1;
//             }
//         }

//         return -1; // Element not found
//     }
// }

// //LC submission 5, 4ms despite being almost same as above
// class Solution {
//     public int search(int[] a, int k) {
//          int l=0;
//         int r=a.length-1;
        
//         while (l<=r) 
//         {
//             if (a[r] == a[l]) {
//                 if (a[l] == k) {
//                     return l;
//                 } else {
//                     return -1;
//                 }
//             }
//             int m=l+((k-a[l])/(a[r]-a[l]))*(r-l);
//             if(m<l||m>r) return -1;
//             if(a[m]==k) return m;
//             if(a[m]<k) l=m+1;
//             else r=m-1;
//         }
//         return -1;
//     }
// }