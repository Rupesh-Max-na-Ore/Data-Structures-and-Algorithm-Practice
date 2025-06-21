package Binary_Search_Tree.lec2_practice_problems;

public class q1_ceil {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        int ans=-1;
        while(root!=null){
            if(root.data == key) return key; //as close we can get
            else if(root.data >key){
                ans = root.data; //possible ans
                root = root.left; //try to go closer
            }
            else root = root.right;//try to go closer
        } return ans;
    }
}
