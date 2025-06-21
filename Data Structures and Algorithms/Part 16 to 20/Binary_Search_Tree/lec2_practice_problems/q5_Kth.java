package Binary_Search_Tree.lec2_practice_problems;

import Binary_Trees.lec2_Mediums.q8_Vertical_Order_Traversal.TreeNode;

public class q5_Kth {
    //Return cnt if cnt != k, else return kth;
    //3rd attempt, correct
    public int kthSmallest(TreeNode root, int k) {
        int[] cnt = {0};  // cnt as a[], to use it like ptr, to reflect changes across recursive calls
        return Inorder(root, cnt, k);
    }

    private int Inorder(TreeNode root, int[] cnt, int k) {
        if (root == null) return -1;  // Handle null node, return -1 if not found

        // L
        int left = Inorder(root.left, cnt, k);
        if (left != -1) return left;  // If the result is found in the left subtree

        // N (root node)
        cnt[0]++;
        if (cnt[0] == k) return root.val;  // Return the k-th smallest value

        // R
        return Inorder(root.right, cnt, k);
    }

    public int kthLargest(TreeNode root, int k) {
        int[] cnt = {0};  // cnt as a[], to use it like ptr, to reflect changes across recursive calls
        return RevInorder(root, cnt, k);
    }

    private int RevInorder(TreeNode root, int[] cnt, int k) {
        if (root == null) return -1;  // Handle null node, return -1 if not found

        // R
        int R = Inorder(root.right, cnt, k);
        if (R != -1) return R;  // If the result is found in the right subtree

        // N (root node)
        cnt[0]++;
        if (cnt[0] == k) return root.val;  // Return the k-th largest value

        // L
        return Inorder(root.left, cnt, k);
    }

    //Return cnt if cnt != k, else return kth;
    //2nd attempt
    // public int kthSmallest(TreeNode root, int k) {
    //     int cnt = 0; int kth = -999; 
    //     return Inorder(root, cnt, kth, k);
    // }

    // private int Inorder(TreeNode root, int cnt, int kth, int k) {
    //     if(root == null) return cnt;
    //     //L
    //     cnt = Inorder(root.left, cnt, kth, k);
    //     //N
    //     cnt++;
    //     if(cnt == k) return root.val;
    //     //R
    //     cnt = Inorder(root.right, cnt, kth, k);

    //     return cnt;

    // }
    
    //Draft
    // public int kthSmallest(TreeNode root, int k) {
    //     int cnt = 0; int kth = -999; 
    //     return Inorder(root, cnt, kth, k);
    // }

    // private int Inorder(TreeNode root, int cnt, int kth, int k) {
    //     if(root == null) return -1;
    //     if(root.val == k) return cnt;

    //     Inorder(root.left, ++cnt, k);
    //     ++cnt;
    //     Inorder(root, ++cnt, k);
    //     return cnt;//never
    // }
}
/*To fix your code for finding the k-th smallest element in a Binary Search Tree (BST), the primary issue is that the values `cnt` and `kth` are being passed by value rather than reference. Hence, modifications to `cnt` and `kth` within the recursive calls are not reflected in the parent function.

One solution is to encapsulate these values in an array (or use a custom class) so that updates are visible across recursive calls. Additionally, there's no need to pass `kth` separately, as it can simply be derived from the in-order traversal.

### Fixed Code

Here’s the corrected version using a wrapper array for `cnt` and avoiding unnecessary parameters:

```java
package Binary_Search_Tree.lec2_practice_problems;

import Binary_Trees.lec2_Mediums.q8_Vertical_Order_Traversal.TreeNode;

public class q5_Kth {
    // Return the k-th smallest element in the BST
    public int kthSmallest(TreeNode root, int k) {
        int[] cnt = {0};  // cnt as an array to reflect changes across recursive calls
        return Inorder(root, cnt, k);
    }

    private int Inorder(TreeNode root, int[] cnt, int k) {
        if (root == null) return -1;  // Handle null node, return -1 if not found

        // L
        int left = Inorder(root.left, cnt, k);
        if (left != -1) return left;  // If the result is found in the left subtree

        // N (root node)
        cnt[0]++;
        if (cnt[0] == k) return root.val;  // Return the k-th smallest value

        // R
        return Inorder(root.right, cnt, k);
    }
}
```

### Explanation:

1. **`cnt[0]`**: We use an array to keep track of the count of nodes visited so far. This allows us to share the updated count across recursive calls.
   
2. **In-order traversal**: The in-order traversal of a binary search tree visits nodes in increasing order of their value. This is why in-order traversal is ideal for finding the k-th smallest element.

3. **Early return**: If we find the k-th smallest element in the left subtree, we immediately return it. Otherwise, we check if the current node is the k-th smallest and finally recurse into the right subtree if needed.

4. **Handling null nodes**: If a subtree is null, we return `-1` to signal that the k-th element was not found in that subtree.

With these corrections, the code will now correctly return the k-th smallest element in the BST. */

//Morris Traversal Method
/*package Binary_Search_Tree.lec2_practice_problems;

import Binary_Trees.lec2_Mediums.q8_Vertical_Order_Traversal.TreeNode;

public class q5_Kth {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        int count = 0; // Counter for the number of visited nodes
        
        while (curr != null) {
            // Case 1: If the left subtree is null, process the current node
            if (curr.left == null) {
                count++;
                
                // If count equals k, we've found the kth smallest element
                if (count == k) {
                    return curr.val;
                }
                
                // Move to the right subtree
                curr = curr.right;
            } else {
                // Case 2: Find the inorder predecessor of the current node
                TreeNode pred = curr.left;
                // Find the rightmost node in the left subtree or the predecessor
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                
                // If the right child of the predecessor is null, set it to the current node
                if (pred.right == null) {
                    pred.right = curr;  // Make a temporary link
                    curr = curr.left;   // Move to the left child
                } else {
                    // If the right child of the predecessor is already pointing to the current node
                    // Restore the tree structure by removing the link
                    pred.right = null;
                    
                    // Process the current node
                    count++;
                    if (count == k) {
                        return curr.val;
                    }
                    
                    // Move to the right subtree
                    curr = curr.right;
                }
            }
        }
        
        return -1; // Return -1 if k is out of bounds
    }
    public int kthLargest(TreeNode root, int k) {
        TreeNode curr = root;
        int count = 0; // Counter to track how many nodes have been visited
        
        while (curr != null) {
            // Case 1: If the right subtree is null, process the current node
            if (curr.right == null) {
                count++;
                
                // If count equals k, we've found the kth largest element
                if (count == k) {
                    return curr.val;
                }
                
                // Move to the left subtree
                curr = curr.left;
            } else {
                // Case 2: Find the inorder predecessor of the current node in the right subtree
                TreeNode pred = curr.right;
                
                // Find the leftmost node in the right subtree (predecessor)
                while (pred.left != null && pred.left != curr) {
                    pred = pred.left;
                }
                
                // If the left child of the predecessor is null, set it to the current node
                if (pred.left == null) {
                    pred.left = curr;  // Make a temporary link
                    curr = curr.right; // Move to the right child
                } else {
                    // If the left child of the predecessor is already pointing to the current node
                    // Restore the tree structure by removing the link
                    pred.left = null;
                    
                    // Process the current node
                    count++;
                    if (count == k) {
                        return curr.val;
                    }
                    
                    // Move to the left subtree
                    curr = curr.left;
                }
            }
        }
        
        return -1; // Return -1 if k is out of bounds
    }
}
 */