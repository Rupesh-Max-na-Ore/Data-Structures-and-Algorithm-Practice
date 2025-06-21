package Heaps_And_PriorityQueues.Lec1_Learning;
/*Q1 */
public class Q1_Implementation_of_Priority_Queue_using_Binary_Heap {
    
}
// //{ Driver Code Starts
// //Initial Template for Java

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// class GFG{
//     public static int H[]=new int[10009];
//     public static int s=-1;
    
//     public int parent(int i){
//         return (i-1)/2;
        
//     }
//     public int leftChild(int i){
//         return ((2*i)+1);
//     }
//     public int rightChild(int i){
//         return ((2*i)+2);
//     }
//     public void shiftUp(int i){
//         while(i>0 && H[parent(i)] < H[i]){
//             int temp=H[i];
//             H[i]=H[parent(i)];
//             H[parent(i)]=temp;
//             i=parent(i);
//         }
//     }
    
//     public void shiftDown(int i){
//         int maxIndex=i;
//         int l=leftChild(i);
//         if(l<=s && H[l]>H[maxIndex] ){
//             maxIndex=l;
//         }
//         int r=rightChild(i);
        
//         if(r<=s && H[r]>H[maxIndex] ){
//             maxIndex=r;
//         }
//         if(i!=maxIndex){
//             int temp=H[i];
//             H[i]=H[maxIndex];
//             H[maxIndex]=temp;
//             shiftDown(maxIndex);
//         }
//     }
    
//     public void insert(int p){
//         s=s+1;
//         H[s]=p;
//         shiftUp(s);
//     }

//     public static void main(String args[]) throws IOException{
//         Scanner sc=new Scanner(System.in);
//         GFG ob=new GFG();
//         int t=sc.nextInt();
//         while(t-->0){
//             int N=sc.nextInt();
//             for(int i=0;i<N;i++){
//                 int k=sc.nextInt();
//                 ob.insert(k);
//             }
            
//             Solution obj=new Solution();
//             System.out.println("Node with maximum priority : "+ obj.extractMax());
//             System.out.print("Priority queue after extracting maximum : ");
//             int j=0;
//             while(j<=ob.s){
//                 System.out.print(ob.H[j]+" ");
//                 j++;
//             }
//             System.out.println();
//         }
//     }
// }
// // } Driver Code Ends


// //User function Template for Java

// //  public static int H[]=new int[10009];
// //  public static int s=-1;
// // 1. parent(i): Function to return the parent node of node i
// // 2. leftChild(i): Function to return index of the left child of node i
// // 3. rightChild(i): Function to return index of the right child of node i
// // 4. shiftUp(int i): Function to shift up the node in order to maintain the
// // heap property
// // 5. shiftDown(int i): Function to shift down the node in order to maintain the
// // heap property.
// // int s=-1, current index value of the array H[].

// // You have to make a class of GFG to access the above functionalities like this - GFG obj=new GFG();
// // You can check the driver code for better understanding.
// class Solution {
//   //gfg submission
//   public int extractMax() {
//         GFG obj=new GFG();
//         int maxRightNow= obj.H[0];
//         obj.H[0]=obj.H[obj.s];
//         obj.s--;
//         obj.shiftDown(0);
//         return maxRightNow;
//     }
// };