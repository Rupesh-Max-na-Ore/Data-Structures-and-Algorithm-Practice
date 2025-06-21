package Binary_Trees.lec3_Hards;

import java.util.ArrayList;

import Binary_Trees.TreeNode;
/*Q1 Root to Leaf Paths
Difficulty: MediumAccuracy: 43.65%Submissions: 112K+Points: 4
Given a Binary Tree of nodes, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

Example 1:

Input:
       1
    /     \
   2       3
Output: 
1 2 
1 3 
Explanation: 
All possible paths:
1->2
1->3
Example 2:

Input:
         10
       /    \
      20    30
     /  \
    40   60
Output: 
10 20 40 
10 20 60 
10 30 
Your Task:
Your task is to complete the function Paths() which takes the root node as an argument and returns all the possible paths. (All the paths are printed in new lines by the driver's code.)

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(height of the tree)

Constraints:
1<=n<=10^4

 */
public class q1_Root_to_Node_Path {

    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        ArrayList<Integer> leafPath = new ArrayList<>();
        getPath(root, leafPath, ans);
        //ans.remove(ans.size()-1);
        return ans;


    }
        public static void getPath(TreeNode node, ArrayList<Integer> leafPath, ArrayList<ArrayList<Integer>> ans){
        if(node==null){
            return;
        }
        leafPath.add(node.data);
        
        if(node.left==null && node.right==null){
            ans.add(new ArrayList<>(leafPath));
        }
        getPath(node.left,new ArrayList<>(leafPath),ans);
        getPath(node.right,new ArrayList<>(leafPath),ans);
        leafPath.remove(leafPath.size()-1);
    }
    // public ArrayList<ArrayList<Integer>> Paths(TreeTreeNode root) {
    //     ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    //     if(root == null) return ans;
    //     ArrayList<Integer> leafPath = new ArrayList<>();
    //     getPath(root, leafPath, ans);
    //     return ans;

    // }

    // public boolean getPath(TreeNode node, ArrayList<Integer> leafPath, ArrayList<ArrayList<Integer>> ans){
    //     if(node == null) return false;
    //     leafPath.add(node.data);
    //     // Only If the node is a leaf, add the current path to the result
    //     if (node.left == null && node.right == null) {
    //         ans.add(new ArrayList<>(leafPath));  // Make a deep copy of the current path and add it to the result
    //     } else {
    //         // Recurse for the left and right children iff curr TreeNode ain't leaf
    //         getPath(node.left, leafPath, ans);
    //         getPath(node.right, leafPath, ans);
    //     }
    //     leafPath.remove(leafPath.size()-1); // Backtrack
    //     return false; 
    // }

    // // //Wrong attempt 1
    // // public boolean getPath(TreeNode node, ArrayList<Integer> leafPath, ArrayList<ArrayList<Integer>> ans){
    // //     if(node == null) return false;
    // //     leafPath.add(node.data);
    // //     boolean lAns = getPath(node.left, leafPath, ans);
    // //     boolean rAns = getPath(node.right, leafPath, ans);
    // //     if((!lAns && !rAns)) ans.add(leafPath);
    // //     if(lAns||rAns) return true;
    // //     leafPath.remove(leafPath.size()-1); // Backtrack
    // //     return false; 
    // // }
}
