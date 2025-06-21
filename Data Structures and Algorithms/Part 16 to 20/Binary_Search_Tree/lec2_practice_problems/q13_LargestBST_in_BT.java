package Binary_Search_Tree.lec2_practice_problems;

public class q13_LargestBST_in_BT {
    static class NOVA {

        int size;
        int max;
        int min;

        public NOVA(int size, int max, int min) {
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    static int largestBst(Node root)
    {
        NOVA result = largestBSTHelper(root);
        return result.size;
    }
    
    private static NOVA largestBSTHelper(Node root) {

        if (root == null) {
            return new NOVA(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        //Do Postorder Cuz want to process curr node only after L and R
        NOVA left = largestBSTHelper(root.left);
        NOVA right = largestBSTHelper(root.right);

        if (root.data > left.max && root.data < right.min) {
            return new NOVA(left.size + right.size + 1, 
                            Math.max(root.data, right.max), 
                            Math.min(root.data, left.min));
        } 
        //else
        return new NOVA(Math.max(left.size, right.size), 
                            Integer.MAX_VALUE, 
                            Integer.MIN_VALUE);
        
    }
    
    
}
