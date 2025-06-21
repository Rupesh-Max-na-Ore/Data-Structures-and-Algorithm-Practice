package Binary_Search_Tree.lec2_practice_problems;
import java.util.Stack;

import Binary_Trees.lec3_Hards.q14_Flatten_BTtoLinkedList.TreeNode;
public class q10_BST_iterator {
    //Should take O(h) space and ~O(1) Time - use Stack, push all left
    ////Should take O(h) space and ~O(1) Time && modifying Tree Allowed - use Morris Traversal
    
}
class BSTIterator {
    private Stack<TreeNode> st= new Stack<TreeNode>();

    public BSTIterator(TreeNode root) { // as soon as we start , we will go to the extreme left as per the inorder
        pushAllLeft(root);
    }
    
    public int next() { // we will be returning the node over here and it will be done as per inorder
        TreeNode node= st.pop();
        pushAllLeft(node.right);    // if the node has right element then it will push all the left of the right node
        return node.val;
    }
    
    public boolean hasNext() {  // if st is not empty means there is a next element present so return true or return false
        return !st.isEmpty();
    }

    public void pushAllLeft(TreeNode node){ // is will pushh all thhe node.left in the st
        while(node!= null){
            st.push(node);
            node= node.left;
        }
    }
}

// //Morris Traversal Method
// class BSTIterator {
//     TreeNode curr;

//     public BSTIterator(TreeNode root) {
//         curr = root;
//     }
    
//     public int next() {
//         int val;
//         while(true){
//             if(curr.left == null){
//                 val = curr.val;
//                 curr = curr.right;
//                 break;
//             }else{
//                 TreeNode prev = curr;
//                 curr = curr.left;
//                 while(curr.right != null && curr.right != prev){
//                     curr = curr.right;
//                 } 
//                 if(curr.right == null){
//                     curr.right = prev;
//                     curr = prev.left;
//                 }else{
//                     curr.right = null;
//                     val = prev.val;
//                     curr = prev.right;
//                     break;
//                 } 
//             }  
//         }
//         return val;
//     }
    
//     public boolean hasNext() {
//         return curr != null;
//     }
// }

/*
//If anyone is wondering how to solve the merging of BST - 
//here's my solution using the iterator ( I added peek() to make it easier to compare. 

class BSTIterator{
    
    private:
        stack<Node*>st;
    
    public:
        BSTIterator(Node* root){
            push_all(root);
        }
        //return if more elements are left in tree traversal or not.
        bool hasNext(){
            return !st.empty();
        }
        //return the next item in inorder traversal.
        int next(){
            Node* temp=st.top();
            st.pop();
            
            if(temp->right){
                push_all(temp->right);
            }
            return temp->data;
        }
        
        int peek(){
            return st.top()->data;
        }
    private:    
        void push_all(Node* root){
            
            while(root){
                st.push(root);
                root=root->left;
            }
        }
        
};

class Solution
{
    public:
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    vector<int> merge(Node *root1, Node *root2)
    {
       vector<int> ans;
       BSTIterator a(root1);
       BSTIterator b(root2);
       
       while(a.hasNext() and b.hasNext()){
           if(a.peek()<=b.peek()){
               ans.push_back(a.next());
           } else {
               ans.push_back(b.next());
           }
       }
       
       while(a.hasNext()) ans.push_back(a.next());
       
       while(b.hasNext()) ans.push_back(b.next());
       
       return ans;
    }
}; 

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    // Check if there are more elements in the inorder traversal
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Return the next item in inorder traversal
    public int next() {
        TreeNode temp = stack.pop();

        if (temp.right != null) {
            pushAll(temp.right);
        }

        return temp.val;
    }

    // Peek the current element at the top of the stack
    public int peek() {
        return stack.peek().val;
    }

    // Helper function to push all left children to the stack
    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

class Solution {
    // Function to return a list of integers denoting the node 
    // values of both the BSTs in a sorted order.
    public List<Integer> merge(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        BSTIterator a = new BSTIterator(root1);
        BSTIterator b = new BSTIterator(root2);

        while (a.hasNext() && b.hasNext()) {
            if (a.peek() <= b.peek()) {
                result.add(a.next());
            } else {
                result.add(b.next());
            }
        }

        while (a.hasNext()) {
            result.add(a.next());
        }

        while (b.hasNext()) {
            result.add(b.next());
        }

        return result;
    }
}
*/