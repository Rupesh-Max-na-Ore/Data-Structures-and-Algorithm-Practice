package Binary_Search_Tree.lec2_practice_problems;

public class q2_floor {
    int floor(Node root, int x) {
        // Code here
        int ans=-1;
        while(root!=null){
            if(root.data == x) return x; //as close we can get
            else if(root.data <x){
                ans = root.data; //possible ans
                root = root.right; //try to go closer
            }
            else root = root.left;//try to go closer
        } return ans;
    }
}
