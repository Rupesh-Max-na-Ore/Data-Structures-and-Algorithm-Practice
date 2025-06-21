package Heaps_And_PriorityQueues.Lec1_Learning;
/*Q3 */
public class Q3_Does_array_represent_Heap {
    public boolean countSub(long a[], long n)
    {
        for(int i=0;i<n;i++){
           int left=2*i+1;
           int right=2*i+2;
           if(left <n && a[i]<a[left]) return false;
           if(right <n && a[i]< a[right]) return false;
        }
        return true;
    }
}
