package Binary_Trees.lec1_Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Binary_Trees.TreeNode;

public class q9_Iterative_Preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        pre(root, al);
        return al;
    }
    public void pre(TreeNode root, List<Integer> al){
        if(root==null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(st.isEmpty()==false){
            TreeNode node = st.pop();
            al.add(node.data);
            if(node.right!=null) st.push(node.right);
            if(node.left!=null) st.push(node.left);
        }
        
    }
}
