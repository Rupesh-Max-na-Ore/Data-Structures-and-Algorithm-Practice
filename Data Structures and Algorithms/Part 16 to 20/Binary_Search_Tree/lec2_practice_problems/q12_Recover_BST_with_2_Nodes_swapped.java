package Binary_Search_Tree.lec2_practice_problems;

import Binary_Trees.lec3_Hards.q14_Flatten_BTtoLinkedList.TreeNode;

public class q12_Recover_BST_with_2_Nodes_swapped {
    TreeNode L;
    TreeNode M;
    TreeNode R;
    TreeNode prev;

    public void recoverTree(TreeNode root) {
        L=M=R=null;
        prev = new Binary_Trees.TreeNode(Integer.MIN_VALUE);

        inorder(root);
        //2nd vilation exist
        if(R!=null){
            //Swap(L,R)
            int t= L.val;
            L.val=R.val;
            R.val=t;
        }else //only 1 violation found
        {
            //Swap(L,R)
            int t= L.val;
            L.val=M.val;
            M.val=t;
        }
    }

    private void inorder(TreeNode root) {
        //Aim - get L,M,R(if exist)
        if(root==null) return;
        //lft
        inorder(root.left);
        //Nd
        //if prev exist && detect violation of ASC order
        if(prev!=null && (root.val<prev.val))
        {
            //Store 1st violation in L
            if(L==null){
                L=prev;
                M=root;
            }
            else //store 2nd violation in R
            {R=root;}
        }
        //Mark curr node as prev
        prev = root;
        // Move to Rht
        inorder(root.right);
    }
    
}
