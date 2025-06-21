package Binary_Trees.lec2_Mediums;

import java.util.ArrayList;
import java.util.List;

import Binary_Trees.TreeNode;

public class q12_Left_View {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        leftView(root,0,ans);
        return ans;
    }
    public void leftView(TreeNode node, int lvl, List<Integer> ans){
        if(node == null) return;

        //SMart! SIze of ans list always > level we currently at if repeat N L R traversal
        if(ans.size()==lvl) ans.add(node.data);
        //go to left then right
        leftView(node.left, lvl+1, ans);
        leftView(node.right, lvl+1, ans);

    }
}
