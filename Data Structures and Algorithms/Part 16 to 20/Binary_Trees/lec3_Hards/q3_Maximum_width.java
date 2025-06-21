package Binary_Trees.lec3_Hards;

import java.util.LinkedList;
import java.util.Queue;

import Binary_Trees.TreeNode;

public class q3_Maximum_width {
    public class tuple{
        public int x;
        public TreeNode node;
        tuple(TreeNode node, int x){
            this.node = node;
            this.x=x;
        }
    } 

    public int widthOfBinaryTree(TreeNode root) {
        int maxi=0;
        if(root==null) return maxi;// 0
        Queue<tuple> q= new LinkedList<>();
        q.add(new tuple(root, 0));
        while(!q.isEmpty()){
            int currN = q.size(); // #nodes this lvl
            int L=-1,R=-1;//min of lvl and max of lvl
            int minL = q.peek().x;
            for(int i=0; i<currN; i++){
                int currI= q.peek().x - minL; //Relative indexeing to Leftmost
                if(i==0) L = currI;
                if(i==currN-1) R = currI;
                tuple tn = q.poll();
                TreeNode currTn = tn.node;
                int currX = tn.x;
                //insane overlap for big trees if not 2*currX
                if(currTn.left!=null) q.add(new tuple(currTn.left, 2*currX+1));
                if(currTn.right!=null) q.add(new tuple(currTn.right, 2*currX+2));
            }
            int currT = R-L+1;
            maxi = (maxi<currT)? currT:maxi;
        } return maxi;
    }
}
