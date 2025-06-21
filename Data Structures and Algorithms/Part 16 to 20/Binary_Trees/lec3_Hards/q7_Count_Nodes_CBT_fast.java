package Binary_Trees.lec3_Hards;

import Binary_Trees.TreeNode;

public class q7_Count_Nodes_CBT_fast {
    //TC - O((log_2(n))^2) WC (why? revise), SC - O(log_2(N))
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int lht = lht(root);
        int rht = rht(root);
        //if(lht==rht) return ((1<<(lht+1))-1); //Wrong, think why? for revision
        if(lht==rht) return ((1<<(lht))-1);

        //else
        int cntL=countNodes(root.left);
        int cntR=countNodes(root.right);
        int total = 1 + cntL + cntR; //curr Node + #left subtree nodes + #right subtree nodes
        return total;
    }

    private int rht(TreeNode root) {
        int rht = 0;
        while(root!=null){
            rht++;
            root = root.right;
        }
        return rht;
    }

    private int lht(TreeNode root) {
        int lht = 0;
        while(root!=null){
            lht++;
            root = root.left;
        }
        return lht;
    }

}
/*//same
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int lht = lht(root);
        int rht = rht(root);
        if(lht==rht) return ((1<<(lht))-1);
        //else
        int cntL=countNodes(root.left);
        int cntR=countNodes(root.right);
        int total = 1 + cntL + cntR;
        return total;
    }

    private int rht(TreeNode root) {
        int rht = 0;
        while(true){
            root = root.right;
            rht++;
            if(root==null) break;

        }
        return rht;
    }

    private int lht(TreeNode root) {
        int lht = 0;
        while(true){
            root = root.left;
            lht++;
            if(root==null) break;
        }
        return lht;
    }
} */
/*private int rht(TreeNode root) {
        int rht = 0;
        while(true){
            if(root==null) break;
            root = root.right;
            rht++;
        }
        return rht;
    }

    private int lht(TreeNode root) {
        int lht = 0;
        while(true){
            if(root==null) break;
            root = root.left;
            lht++;
        }
        return lht;
    } */

/*class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int lht = lht(root);
        int rht = rht(root);
        if(lht==rht) return ((1<<(lht+1))-1); //here it's correct
        //else
        int cntL=countNodes(root.left);
        int cntR=countNodes(root.right);
        int total = 1 + cntL + cntR;
        return total;
    }

    private int rht(TreeNode root) {
        int rht = 0;
        while(true){
            root = root.right;
            if(root==null) break;
            rht++;
        }
        return rht;
    }

    private int lht(TreeNode root) {
        int lht = 0;
        while(true){
            root = root.left;
            if(root==null) break;
            lht++;
        }
        return lht;
    }
} */