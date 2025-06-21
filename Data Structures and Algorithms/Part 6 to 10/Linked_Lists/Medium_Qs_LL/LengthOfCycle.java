package Linked_Lists.Medium_Qs_LL;
// q6
import Linked_Lists.Singly_Linked_List.LinkedList.Node;

public class LengthOfCycle {
    // attempt 2, correct
        //Function to find the length of a loop in the linked list.
        static int countNodesinLoop(Node h)
        {
            Node s=h;
            Node f=h;
            int cnt=0;
            while(f!=null&&f.next!=null){
                s=s.next;
                f=f.next.next;
                if(s==f) break; // if cycle. s has travelled L1+d 
            }
            if(f==null||f.next==null) return 0; // no cycle
            cnt++;
            s=s.next; // if cycle
            while(s!=f){
                s=s.next;
                cnt++;
            } //s remeet f after L1 nodes
            return cnt;
        }
    
    // attempt 1
    //Function to find the length of a loop in the linked list.
    // static int countNodesinLoop(Node h)
    // {
    //     Node s=h;
    //     Node f=h;
    //     int cnt=1;
    //     while(f!=null&&f.next!=null){
    //         s=s.next;
    //         //cnt++;
    //         f=f.next.next;
    //         if(s==f) break; // if cycle. s has travelled L1+d 
    //     }
    //     if(f==null||f.next==null) return 0; // no cycle
    //     cnt++;
    //     s=h; // if cycle
    //     while(s!=f){
    //         s=s.next;
    //         cnt--;
    //         //f=f.next;
    //     } //s remeet f after L1 nodes
    //     return cnt;
    // }
}
