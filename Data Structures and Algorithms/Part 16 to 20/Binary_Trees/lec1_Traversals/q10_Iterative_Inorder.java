package Binary_Trees.lec1_Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Binary_Trees.TreeNode;

public class q10_Iterative_Inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        in(root, al);
        return al;
    }
        public void in(TreeNode root, List<Integer> al){
        // l n r
        if(root==null) return;
        Stack<TreeNode> st = new Stack<>();
        //st.push(root);
        TreeNode node = root;

        while(true){
            if(node!=null){
                st.push(node);
                node=node.left;
            }
            else{
                if(st.isEmpty()) break;
                node=st.pop();
                al.add(node.data);
                node=node.right;
            }
        }
    }
}
