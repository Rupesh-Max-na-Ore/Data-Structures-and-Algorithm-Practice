package Binary_Trees.lec2_Mediums;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import Binary_Trees.TreeNode;

public class q9_Top_View {
    class Tuple{
        TreeNode node;
        int X;
        Tuple(TreeNode _node, int _X){
            node = _node;
            X = _X;
        }
    }
    ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        TreeMap<Integer, Integer> Tmap = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0));
        while(!q.isEmpty()){
            Tuple currTuple = q.poll();
            int currX=currTuple.X;
            TreeNode currTreeNode = currTuple.node;
            Tmap.putIfAbsent(currX, currTreeNode.data);//Only put if absent
            if(currTreeNode.left!=null) q.add(new Tuple(currTreeNode.left, currX-1));
            if(currTreeNode.right!=null) q.add(new Tuple(currTreeNode.right, currX+1));
        }
        for(int k:Tmap.keySet()){
            ans.add(Tmap.get(k));
        }
        return ans;
    }
}
