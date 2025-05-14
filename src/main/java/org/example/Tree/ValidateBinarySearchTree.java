package org.example.Tree;

public class ValidateBinarySearchTree {

    //check if a binary tree is a valid BST using inorder traversal

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(12);
        root.right = new TreeNode(21);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(15);
        root.left.left.right = new TreeNode(16);

        int[] prev = {Integer.MIN_VALUE};

        System.out.println("Is the binary tree a valid BST? " + isValidBST(root, prev));
    }

    /*isValidBST:
    * 1. if root is null
    *   -return true
    * 2. if left subtree is not a valid BST
    *   -return false
    * 3. if root key is less than or equal to previous key
    *   -return false
    * 4. update previous key to current root key
    * 5. if right subtree is not a valid BST
    *   -return false
    * 6. if all of the above conditions are false
    *   -return true
    *
    * here were are using an int array to store the previous key
    * this is because we need to pass the previous key by reference
    * we cannot use a simple int variable because it will be passed by value
    * we need to update the previous key in the recursive calls
    * */
    public static boolean isValidBST(TreeNode root, int[] prev){
        if(root == null)
            return true;
        if(!isValidBST(root.left, prev))
            return false;

        if(root.key <= prev[0])
            return false;

        prev[0] = root.key;

        return isValidBST(root.right, prev);

    }

}
