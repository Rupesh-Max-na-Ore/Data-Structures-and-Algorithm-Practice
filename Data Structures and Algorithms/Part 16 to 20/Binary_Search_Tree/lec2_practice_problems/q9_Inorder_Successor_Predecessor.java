package Binary_Search_Tree.lec2_practice_problems;

import Binary_Trees.lec3_Hards.q14_Flatten_BTtoLinkedList.TreeNode;

public class q9_Inorder_Successor_Predecessor {
    TreeNode Successor(TreeNode root, TreeNode k){
        TreeNode s = null;
        while(root!=null){
            if(root.val>k){
                s=root;//possible ans
                root=root.left;//try to find a val closer to k
            }
            else if(root.val<k) root=root.right;//go closer to k, need strictly gt k
        } //it's like Binary Search in the sense, we reject a subtree per node we visit, reducing search space by 2
        return s;
    }
    TreeNode Predeccessor(TreeNode root, TreeNode k){
        TreeNode p = null;
        while(root!=null){
            if(root.val<k){
                p=root;//possible ans
                root=root.left;//try to find a val closer to k, by going left, as we are in <k territory already
            }
            else if(root.val>k) root=root.right;//go closer to k, need strictly lt k
        } //it's like Binary Search in the sense, we reject a subtree per node we visit, reducing search space by ~2
        return p;
    }
}
