package Binary_Trees.lec3_Hards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import Binary_Trees.lec2_Mediums.q8_Vertical_Order_Traversal.TreeNode;

public class q5_All_Nodes_Distance_K {
    public void mapParent(TreeNode root,Map<TreeNode,TreeNode> parent)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node=q.poll();
            if(node.left!=null)
            {
                parent.put(node.left,node);
                q.add(node.left);
            }
            if(node.right!=null)
            {
                parent.put(node.right,node);
                q.add(node.right);
            }

        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parent=new HashMap<>();
        mapParent(root,parent);
        Map<TreeNode,Boolean> vis=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        vis.put(target,true);
        int lvl=0;
        while(!q.isEmpty() && lvl!=k)
        {
            lvl++;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
            TreeNode curr=q.poll();
            if(curr.left!=null && vis.get(curr.left)==null)
            {
                q.add(curr.left);
                vis.put(curr.left,true);
            }
             if(curr.right!=null && vis.get(curr.right)==null)
            {
                q.add(curr.right);
                vis.put(curr.right,true);
            }
            if(parent.get(curr)!=null && vis.get(parent.get(curr))==null)
            {
                q.add(parent.get(curr));
                vis.put(parent.get(curr),true);
            }
            }



        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            ans.add(q.poll().val);
        }
        return ans;
        
    }
}
