package Binary_Trees.lec3_Hards;

import Binary_Trees.TreeNode;

public class q4_Convert_to_Child_Sum_Property {
    public void changeToCSP(TreeNode node){
        if(node==null) return;
        int childVal=0;
        if(node.left!=null) childVal+=node.left.data;
        if(node.right!=null) childVal+=node.right.data;
        if(childVal>=node.data) node.data = childVal;
        else{
            if(node.left!=null) node.left.data=node.data;
            if(node.right!=null) node.right.data=node.data;
        }
        changeToCSP(node.left);
        changeToCSP(node.right);
        int total=0;
        if(node.left!=null) total+=node.left.data;
        if(node.right!=null) total+=node.right.data;
        if(node.left!=null||node.right!=null)node.data = total;
    }

    //gfg submission
    // //Function to check whether all nodes of a tree have the value 
    // //equal to the sum of their child nodes.
    // public static int isSumProperty(Node root)
    // {
    //     // add your code here
    //     if(root==null) return 1;
    //     if(root.left==null & root.right==null) return 1;
    //     int sum=0;
    //     if(root.left!=null)sum+=root.left.data;
    //     if(root.right!=null)sum+=root.right.data;
    //     if(root.data==sum) return (isSumProperty(root.left)&isSumProperty(root.right));
    //     return 0;
        
    // }
}

/*An important optimization:
We don't need to consider the case where child>=root->data.
We only need to consider the case where child<root->data and increase the value of child to root->data.
The optimized code:
void changeTree(BinaryTreeNode < int > * root) {
    if(root==NULL)
    return;
    int child=0;
    
    if(root->left)
    child+=root->left->data;
    if(root->right)
    child+=root->right->data;

    //we make sure that while going down the child has no shortage
    if(child < root->data)
    {
        if(root->left)
        {
            root->left->data=root->data;
        }
        if(root->right)
        {
            root->right->data=root->data;
        }
    }

    changeTree(root->left);
    changeTree(root->right);

    //while going back up
    int tot=0;
    if(root->left)
    tot+=root->left->data;
    if(root->right)
    tot+=root->right->data;
    
    if(root->left || root->right)
    root->data=tot;
} */