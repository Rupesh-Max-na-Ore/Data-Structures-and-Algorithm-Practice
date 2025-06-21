package Binary_Trees.lec3_Hards;
public class q6_Burn_Time_DFS {

    // Node definition
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static int maxTime = 0;  // To store the maximum burn time across the tree

    public static int minTime(Node root, int target) {
        maxTime = 0;
        // Find the target and calculate the burn time recursively
        burnTree(root, target);
        return maxTime;
    }

    /**
     * burnTree: Finds the target node, propagates the burn time, and updates maxTime.
     * 
     * @param root   Current node in the binary tree
     * @param target The target node value where the fire starts
     * @return The distance from the current node to the target node, or -1 if the node is not part of the target path
     */
    private static int burnTree(Node root, int target) {
        // Base case: If the node is null, return -1 (indicating target not found)
        if (root == null) {
            return -1;
        }

        // If the current node is the target node, start burning process
        if (root.data == target) {
            // Start burning from here, check how long it takes to burn the subtrees
            burnSubtree(root, 0);  // Burn the subtree rooted at this node (starting with time 0)
            return 1;  // Return the distance 1 (target node burns and sends the fire upwards)
        }

        // Recursively check the left subtree for the target
        int leftDistance = burnTree(root.left, target);
        if (leftDistance != -1) {
            // Target is in the left subtree, propagate burn to the right subtree
            burnSubtree(root.right, leftDistance);  // Burn right subtree with the increasing time
            maxTime = Math.max(maxTime, leftDistance);  // Update the maximum time for this path
            return leftDistance + 1;  // Return distance to propagate upwards
        }

        // Recursively check the right subtree for the target
        int rightDistance = burnTree(root.right, target);
        if (rightDistance != -1) {
            // Target is in the right subtree, propagate burn to the left subtree
            burnSubtree(root.left, rightDistance);  // Burn left subtree with the increasing time
            maxTime = Math.max(maxTime, rightDistance);  // Update the maximum time for this path
            return rightDistance + 1;  // Return distance to propagate upwards
        }

        // If target is not in either subtree, return -1
        return -1;
    }

    /**
     * burnSubtree: Burns the subtree rooted at 'root' and increases the time accordingly.
     * 
     * @param root Current node in the binary tree
     * @param time Current time when this subtree starts burning
     */
    private static void burnSubtree(Node root, int time) {
        if (root == null) {
            return;
        }

        // Update the maximum burn time
        maxTime = Math.max(maxTime, time);

        // Burn left and right subtrees with increasing time
        burnSubtree(root.left, time + 1);
        burnSubtree(root.right, time + 1);
    }

}
