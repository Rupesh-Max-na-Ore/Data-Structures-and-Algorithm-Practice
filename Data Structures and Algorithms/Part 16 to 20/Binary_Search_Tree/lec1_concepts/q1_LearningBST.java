package Binary_Search_Tree.lec1_concepts;

public class q1_LearningBST {

    boolean isBSTTraversal(int a[]) {
        // Inorder of BST is ASC sorted (non-decreasing order) 
        for(int i =1; i< a.length; i++) if(a[i]<=a[i-1]) return false;
        return true;
    }
}
