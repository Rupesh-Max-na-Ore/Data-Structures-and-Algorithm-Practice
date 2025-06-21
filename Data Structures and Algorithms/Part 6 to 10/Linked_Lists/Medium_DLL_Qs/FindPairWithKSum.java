package Linked_Lists.Medium_DLL_Qs;

import java.util.ArrayList;

import Linked_Lists.Doubly_Linked_List.DoublyLinkedList.Node;
//Q2
public class FindPairWithKSum {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int k, Node h) {
        if(h==null||h.next==null) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> AL = new ArrayList<>();
        Node L = h;
        Node R = h;
        while(R.next!=null) R=R.next;
        while(L.value<R.value){
            int sum=L.value+R.value;
            if(sum==k) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(L.value);
                pair.add(R.value);
                AL.add(pair);
                L=L.next;
                R=R.previous;
            } else if(sum<k) L=L.next;
            else R=R.previous;
        } return AL;
    }

}
