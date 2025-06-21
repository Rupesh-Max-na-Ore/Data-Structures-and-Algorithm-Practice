package Linked_Lists.Medium_Qs_LL;

import Linked_Lists.Singly_Linked_List.LinkedList.Node;
// Q14
public class Add1toSLL {
    public static Node addOne(Node h) 
    { 
            if(h==null){
                // create a node with 1 and return it
                Node One = new Node(1);
                One.next=null;
                return One;
            }
            // reverse SLL
            h = RecursiveReverseSLL.reverseSLL(h);
            // 1st place(LSB)
            int c=1;
            // To traverse
            Node t = h;
            while(t!=null){
                if(t.value+c>=10){
                    t.value=0;
                    c=1;
                } else if (t.value+c<10) {
                    t.value+=c;
                    c=0; // carry for next higher place
                } t=t.next;
            }

            h = RecursiveReverseSLL.reverseSLL(h);

            if(c!=1){
                return h;
            } else{
                // create a node with 1 and return it
                Node One = new Node(1);
                One.next=h;
                return One;
            }
    }

}

// // gfg sub
// //{ Driver Code Starts
//     import java.io.*;
//     import java.util.*;
//     class Node
//     {
//         int data;
//         Node next;
        
//         Node(int x)
//         {
//             data = x;
//             next = null;
//         }
//     }
//     class GfG
//     {
//         public static void printList(Node node) 
//         { 
//             while (node != null)
//             { 
//                 System.out.print(node.data);
//                 node = node.next; 
//             }  
//             System.out.println();
//         } 
//         public static void main(String args[])throws IOException
//             {
//                 Scanner sc = new Scanner(System.in);
//                 int t = sc.nextInt();
//                 while(t-->0)
//                     {
//                         String s = sc.next();
//                         Node head = new Node( s.charAt(0) - '0' );
//                         Node tail = head;
//                         for(int i=1; i<s.length(); i++)
//                         {
//                             tail.next = new Node( s.charAt(i) - '0' );
//                             tail = tail.next;
//                         }
//                         Solution obj = new Solution();
//                         head = obj.addOne(head);
//                         printList(head); 
//                     }
//             }
//     }
    // // } Driver Code Ends
    
    
    // /*
    // class Node{
    //     int data;
    //     Node next;
        
    //     Node(int x){
    //         data = x;
    //         next = null;
    //     }
    // } 
    // */
    
    // class Solution
    // {
    //     public static Node addOne(Node h) 
    //     { 
    //         //code here.
    //         if(h==null){
    //                 // create a node with 1 and return it
    //                 Node One = new Node(1);
    //                 One.next=null;
    //                 return One;
    //             }
    //             // reverse SLL
    //             h = reverseSLL(h);
    //             // 1st place(LSB)
    //             int c=1;
    //             // To traverse
    //             Node t = h;
    //             while(t!=null){
    //                 if(t.data+c>=10){
    //                     t.data=0;
    //                     c=1;
    //                 } else if (t.data+c<10) {
    //                     t.data+=c;
    //                     c=0; // carry for next higher place
    //                 } t=t.next;
    //             }
    
    //             h = reverseSLL(h);
    
    //             if(c!=1){
    //                 return h;
    //             } else{
    //                 // create a node with 1 and return it
    //                 Node One = new Node(1);
    //                 One.next=h;
    //                 return One;
    //             }
    //     }
    //     public static Node reverseSLL(Node h){
    //         if(h==null||h.next==null) return h;
    
    //         Node Pt=null;
    //         Node t=h;
    //         Node Ft=h.next;
    
    //         while(t!=null){
    //             t.next=Pt;
    //             Pt=t;
    //             t=Ft;
    //             if(Ft==null) h=t;
    //             else Ft = Ft.next;
    //         }
    //         return Pt;
    //     }
    // }
    