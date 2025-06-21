package Binary_Trees.lec2_Mediums;

import java.util.LinkedList;
import java.util.Queue;

import Binary_Trees.TreeNode;

public class q1_Height {
    public int maxDepth(TreeNode root) {
        //BFS, explicit Queue
        if(root==null) return 0;
        Queue <TreeNode> Q = new LinkedList<>();
        int ht=0;
        Q.add(root);
        while(!Q.isEmpty()){
            ht++;
            int n = Q.size();
            for(int i=0; i<n;i++){
                TreeNode x = Q.remove();
                if(x.left != null) Q.add(x.left);
                if(x.right != null) Q.add(x.right);
            }
        }
        return ht;
    }
    // public int maxDepth(TreeNode root) {
    //     //Recursive way (DFS)
    //     //Base
    //     if(root==null) return 0;
    //     //Induction
    //     int lht=maxDepth(root.left);
    //     int rht=maxDepth(root.right);
    //     return 1+Math.max(lht, rht);
    // }
}
