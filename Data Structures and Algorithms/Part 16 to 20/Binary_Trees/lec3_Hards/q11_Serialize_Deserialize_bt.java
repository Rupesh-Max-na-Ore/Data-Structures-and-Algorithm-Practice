package Binary_Trees.lec3_Hards;
/*Q11 297. Serialize and Deserialize Binary Tree
Hard
Topics
Companies
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
Seen this question in a real interview before?
1/5
Yes
No
Accepted
934.3K
Submissions
1.6M
Acceptance Rate
57.6% */

import java.util.LinkedList;
import java.util.Queue;

public class q11_Serialize_Deserialize_bt {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string using level-order traversal.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        // Remove the last unnecessary comma
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }

        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Left child
            if (!nodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                current.left = left;
                queue.add(left);
            }

            i++;//for right child checking

            // Right child
            if (!nodes[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                current.right = right;
                queue.add(right);
            }
            i++;//for next left child checking
        }

        return root;
    }
}
/*//DFS way
package Binary_Trees.lec3_Hards;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class q11_Serialize_Deserialize_bt {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string using preorder traversal.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }
}
 */
/*//using scanner instead of split
 * // Encodes a tree to a single string.
public String serialize(TreeNode root) 
{
    if(root == null) return "#";
    
    return "" + root.val + " " + serialize(root.left) + " " + serialize(root.right);
}


// Decodes your encoded data to tree.
public TreeNode deserialize(String data) 
{
    return build(new Scanner(data));
}

private TreeNode build(Scanner sc)
{
    if(!sc.hasNext()) return null;
    String tk = sc.next();
    if(tk.equals("#")) return null;
    
    TreeNode root = new TreeNode(Integer.parseInt(tk));
    root.left = build(sc);
    root.right = build(sc);
    
    return root;
}
    https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solutions/74417/short-and-clear-recursive-java-solution/
 */

 //https://chatgpt.com/share/67076a87-bcc8-8005-a549-088bd5968905