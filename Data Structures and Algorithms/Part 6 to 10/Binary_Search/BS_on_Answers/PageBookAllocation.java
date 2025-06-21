package Binary_Search.BS_on_Answers;
/*
 * Q9
 * Allocate Minimum Number of Pages

Problem Statement: Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
Allocate books in such a way that:

Each student gets at least one book.
Each book should be allocated to only one student.
Book allocation should be in a contiguous manner.
You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1

Examples
Example 1:
Input Format:
 n = 4, m = 2, arr[] = {12, 34, 67, 90}
Result:
 113
Explanation:
 The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get the last one.

Example 2:
Input Format:
 n = 5, m = 4, arr[] = {25, 46, 28, 49, 24}
Result:
 71
Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24.

We can allocate books in several ways but it is clearly said in the question that we have to allocate the books in such a way that the maximum number of pages received by a student should be minimum.

Assume the given array is {25 46 28 49 24} and number of students, M = 4. Now, we can allocate these books in different ways. Some of them are the following:

25 | 46 | 28 | 49, 24  → Maximum no. of pages a student receive = 73
25 | 46 | 28, 49 | 24  → Maximum no. of pages a student receive = 77
25 | 46, 28 | 49 | 24  → Maximum no. of pages a student receive = 74
25, 46 | 28 | 49 | 24  → Maximum no. of pages a student receive = 71
From the above allocations, we can clearly observe that the minimum possible maximum number of pages is 71.

When it is impossible to allocate books:

When the number of books is lesser than the number of students, we cannot allocate books to all the students even if we give only a single book to each student. So, if m > n, we should return -1.

Observations:

Minimum possible answer: We will get the minimum answer when we give n books of the array to n students(i.e. Each student will receive 1 book). Now, in this case, the maximum number of pages will be the maximum element in the array. So, the minimum possible answer is max(arr[]).
Maximum possible answer: We will get the maximum answer when we give all n books to a single student. The maximum no. of pages he/she will receive is the summation of array elements i.e. sum(arr[]). So, the maximum possible answer is sum(arr[]).
From the observations, it is clear that our answer lies in the range [max(arr[]), sum(arr[])].

How to calculate the number of students to whom we can allocate the books if one can receive at most ‘pages’ number of pages:

In order to calculate the number of students we will write a function, countStudents(). This function will take the array and ‘pages’ as parameters and return the number of students to whom we can allocate the books.

countStudents(arr[], pages):

We will first declare two variables i.e. ‘students’(stores the no. of students), and pagesStudent(stores the number of pages of a student). As we are starting with the first student, ‘students’ should be initialized with 1.
We will start traversing the given array.
If pagesStudent + arr[i] <= pages: If upon adding the pages with the existing number of pages does not exceed the limit, we can allocate this i-th book to the current student.
Otherwise, we will move to the next student(i.e. students += 1 ) and allocate the book.
Finally, we will return the value of ‘students’.
 */
import java.util.ArrayList;
import java.util.List;

public class PageBookAllocation {
    public static int findMaxMinPages(ArrayList<Integer> a, int n, int m) {
        if (m > n) return -1; // Can't go below 1 book per student
        // Find max, min, and sum of elems
        int max = findMax(a);
        if (m==n) return max; // Just go at 1 book per student
        //int min = findMin(a); //not required here, just wrote for practice
        int sum = findSum(a);
        if(m==1) return sum; // Gib all book to 1 and only student
        //Ini. range for BinSrch
        int l=max; int r=sum;
        while(l<=r){
            int maxPg=l+(r-l)/2;
            int StdntCnt=CountStudents(a,maxPg,n,m);
            if(StdntCnt<=m) r=maxPg-1; // possible ans, try for lower valid maxPg 
            else if(StdntCnt>m) l=maxPg+1; // not ans, try for higher valid maxPg
        } return l; // l convrges to correct ans, while r converges to just a little wrong ans
        
    }
    private static int CountStudents(ArrayList<Integer> a, int maxPg, int n, int m) {
        int StdntCnt = 1; 
        long pgAlloc = 0;//a.get(0);
        for (int i = 0; i < n; i++) {
            if (pgAlloc + a.get(i) <= maxPg) {
                // add pages to current student
                pgAlloc += a.get(i);
            } else {
                // add pages to next student
                StdntCnt++;
                pgAlloc = a.get(i);
                if(StdntCnt>m) return StdntCnt; // No need to check further if more students are required than max allowed
            }
        }
        return StdntCnt;
    }
    
    // Mwthods designed for Arraylists
    // Method to find the max value
    public static int findMax(List<Integer> list) {
        int max = list.get(0); // Assume the first elem is the max
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    //Below method not required here, just wrote for practice
    // Method to find the min value
    public static int findMin(List<Integer> list) {
        int min = list.get(0); // Assume the first elem is the min
        for (int num : list) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Method to find the sum of elems
    public static int findSum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Test cases
        ArrayList<Integer> books1 = new ArrayList<>(List.of(12, 34, 67, 90));
        int students1 = 2;
        System.out.println("Test Case 1:");
        System.out.println("Input: books = {12, 34, 67, 90}, students = 2");
        System.out.println("Output: " + findMaxMinPages(books1, books1.size(), students1)); // Expected output: 113

        ArrayList<Integer> books2 = new ArrayList<>(List.of(25, 46, 28, 49, 24));
        int students2 = 4;
        System.out.println("\nTest Case 2:");
        System.out.println("Input: books = {25, 46, 28, 49, 24}, students = 4");
        System.out.println("Output: " + findMaxMinPages(books2, books2.size(), students2)); // Expected output: 71
    }
}

// //CODE360 submission
// import java.util.*;
// public class Solution {
//     public static int findPages(ArrayList<Integer> a, int n, int m) {
//        if (m > n) return -1; // Can't go below 1 book per student
//         // Find max, min, and sum of elems
//         int max = findMax(a);
//         if (m==n) return max; // Just go at 1 book per student
//         //int min = findMin(a); //not required here, just wrote for practice
//         int sum = findSum(a);
//         if(m==1) return sum; // Gib all book to 1 and only student
//         //Ini. range for BinSrch
//         int l=max; int r=sum;
//         while(l<=r){
//             int maxPg=l+(r-l)/2;
//             int StdntCnt=CountStudents(a,maxPg,n,m);
//             if(StdntCnt<=m) r=maxPg-1; // possible ans, try for lower valid maxPg 
//             else if(StdntCnt>m) l=maxPg+1; // not ans, try for higher valid maxPg
//         } return l; // l convrges to correct ans, while r converges to just a little wrong ans
//     }
//     private static int CountStudents(ArrayList<Integer> a, int maxPg, int n, int m) {
//         int StdntCnt = 1; 
//         long pgAlloc = 0;//a.get(0);
//         for (int i = 0; i < n; i++) {
//             if (pgAlloc + a.get(i) <= maxPg) {
//                 // add pages to current student
//                 pgAlloc += a.get(i);
//             } else {
//                 // add pages to next student
//                 StdntCnt++;
//                 pgAlloc = a.get(i);
//                 if(StdntCnt>m) return StdntCnt; // No need to check further if more students are required than max allowed
//             }
//         }
//         return StdntCnt;
//     }
//     // Mwthods designed for Arraylists
//     // Method to find the max value
//     public static int findMax(List<Integer> list) {
//         int max = list.get(0); // Assume the first elem is the max
//         for (int num : list) {
//             if (num > max) {
//                 max = num;
//             }
//         }
//         return max;
//     }
    

//     // Method to find the sum of elems
//     public static int findSum(List<Integer> list) {
//         int sum = 0;
//         for (int num : list) {
//             sum += num;
//         }
//         return sum;
//     }
// }

// import java.util.ArrayList;
// import java.util.List;

// public class PageBookAllocation {
//     public static int findMaxMinPages(ArrayList<Integer> a, int n, int m) {
//         if (m > n) return -1; // Can't allocate more students than books

//         // Find the maximum and sum of elements
//         int max = findMax(a);
//         int sum = findSum(a);
        
//         if (m == n) return max; // If each student gets exactly one book

//         // Initialize the range for binary search
//         int l = max;
//         int r = sum;
//         int result = sum;

//         while (l <= r) {
//             int mid = l + (r - l) / 2;
//             int studentsRequired = countStudents(a, mid);

//             if (studentsRequired <= m) {
//                 result = mid; // Possible answer, try for lower max pages
//                 r = mid - 1;
//             } else {
//                 l = mid + 1; // Not a valid answer, try for higher max pages
//             }
//         }

//         return result;
//     }

//     private static int countStudents(ArrayList<Integer> a, int maxPages) {
//         int studentsRequired = 1;
//         int currentPageSum = 0;

//         for (int pages : a) {
//             if (currentPageSum + pages > maxPages) {
//                 studentsRequired++;
//                 currentPageSum = pages;
//                 if (studentsRequired > maxPages) { // No need to check further if more students are required than max allowed
//                     return studentsRequired;
//                 }
//             } else {
//                 currentPageSum += pages;
//             }
//         }

//         return studentsRequired;
//     }

//     // Methods for ArrayLists
//     // Method to find the max value
//     public static int findMax(List<Integer> list) {
//         int max = list.get(0); // Assume the first element is the max
//         for (int num : list) {
//             if (num > max) {
//                 max = num;
//             }
//         }
//         return max;
//     }

//     // Method to find the sum of elements
//     public static int findSum(List<Integer> list) {
//         int sum = 0;
//         for (int num : list) {
//             sum += num;
//         }
//         return sum;
//     }

//     public static void main(String[] args) {
//         // Test cases
//         ArrayList<Integer> books1 = new ArrayList<>(List.of(12, 34, 67, 90));
//         int students1 = 2;
//         System.out.println("Test Case 1:");
//         System.out.println("Input: books = {12, 34, 67, 90}, students = 2");
//         System.out.println("Output: " + findMaxMinPages(books1, books1.size(), students1)); // Expected output: 113

//         ArrayList<Integer> books2 = new ArrayList<>(List.of(25, 46, 28, 49, 24));
//         int students2 = 4;
//         System.out.println("\nTest Case 2:");
//         System.out.println("Input: books = {25, 46, 28, 49, 24}, students = 4");
//         System.out.println("Output: " + findMaxMinPages(books2, books2.size(), students2)); // Expected output: 71
//     }
// }

/* 
import java.util.ArrayList;
import java.util.List;

public class PageBookAllocation {
    public static int findMaxMinPages(ArrayList<Integer> a, int n, int m) {
        if (m > n) return -1; // Can't allocate more students than books

        // Find the maximum and sum of elements
        int max = findMax(a);
        int sum = findSum(a);
        
        if (m == n) return max; // If each student gets exactly one book

        // Initialize the range for binary search
        int l = max;
        int r = sum;
        int result = sum;

        while (l <= r) {
            int maxPg = l + (r - l) / 2;
            int StdntCnt = countStudents(a, maxPg);

            if (StdntCnt <= m) {
                result = maxPg; // Possible answer, try for lower max pages
                r = maxPg - 1;
            } else {
                l = maxPg + 1; // Not a valid answer, try for higher max pages
            }
        }

        return result;
    }

    private static int countStudents(ArrayList<Integer> a, int maxPg) {
        int StdntCnt = 1;
        int pgAlloc = 0;

        for (int pages : a) {
            if (pgAlloc + pages > maxPg) {
                StdntCnt++;
                pgAlloc = pages;
            } else {
                pgAlloc += pages;
            }
        }

        return StdntCnt;
    }

    // Methods for ArrayLists
    // Method to find the max value
    public static int findMax(List<Integer> list) {
        int max = list.get(0); // Assume the first element is the max
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Method to find the sum of elements
    public static int findSum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Test cases
        ArrayList<Integer> books1 = new ArrayList<>(List.of(12, 34, 67, 90));
        int students1 = 2;
        System.out.println("Test Case 1:");
        System.out.println("Input: books = {12, 34, 67, 90}, students = 2");
        System.out.println("Output: " + findMaxMinPages(books1, books1.size(), students1)); // Expected output: 113

        ArrayList<Integer> books2 = new ArrayList<>(List.of(25, 46, 28, 49, 24));
        int students2 = 4;
        System.out.println("\nTest Case 2:");
        System.out.println("Input: books = {25, 46, 28, 49, 24}, students = 4");
        System.out.println("Output: " + findMaxMinPages(books2, books2.size(), students2)); // Expected output: 71
    }
}
*/