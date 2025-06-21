package Binary_Trees.lec2_Mediums;

import java.util.ArrayList;
import java.util.List;

import Binary_Trees.TreeNode;

public class q11_Right_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        rightView(root,0,ans);
        return ans;
    }
    public void rightView(TreeNode node, int lvl, List<Integer> ans){
        if(node == null) return;

        //SMart! SIze of ans list always > level we currently at if repeat N R L traversal
        if(ans.size()==lvl) ans.add(node.data);
        //go to right then left
        rightView(node.right, lvl+1, ans);
        rightView(node.left, lvl+1, ans);

    }
}
