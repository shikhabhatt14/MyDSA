package org.example.Tree;

public class BinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(12);
        root.right = new TreeNode(21);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(15);

        System.out.println("Inorder traversal of the BST:");
        BinaryTreeInOrderTraversal.inOrderTraversal(root);
        System.out.println();

        int keyToInsert = 10;
        root = insert(root, keyToInsert);
        System.out.println("After inserting " + keyToInsert + ":");
        BinaryTreeInOrderTraversal.inOrderTraversal(root);
        System.out.println();

        int keyToDelete = 12;
        root = delete(root, keyToDelete);
        System.out.println("After deleting " + keyToDelete + ":");
        BinaryTreeInOrderTraversal.inOrderTraversal(root);

    }

    public static TreeNode insert(TreeNode root, int key){
        if(root == null)
            return new TreeNode(key);
        if(key < root.key)
            root.left = insert(root.left, key);
        else if(key > root.key)
            root.right = insert(root.right, key);

        return root;
    }

    public static TreeNode search(TreeNode root, int key){
        if(root == null || root.key == key)
            return root;
        if(key < root.key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

     /* Deletion:
     * 1. if key < root.key
     *      -search in left subtree
     * 2. if key > root.key
     *      -search in right subtree
     * 3. if key == root.key
     *      a. if root has no or just right child
     *         -return right child
     *      b. if root has only left child
     *         -return left child
     *      c. if root has both children
     *         -find the minimum value in the right subtree(Successor of root)
     *         -replace the root with the successor
     *         -delete the successor from the right subtree
     * */

    public static TreeNode delete(TreeNode root, int key){
        if(root == null)
            return root;
        if(key < root.key)
            root.left = delete(root.left, key);
        else if(key > root.key)
            root.right = delete(root.right, key);
        else{
            // If root matches with the given key

            // Cases when root has 0 children or
            // only right child
            if(root.left == null)
                return root.right;
            // Cases when root has only left child
            if(root.right == null)
                return root.left;
            // If root has both children, find the inorder
            // successor (smallest in the right subtree)
            TreeNode succ = successor(root);
            root.key = succ.key;
            root.right = delete(root.right, succ.key);
        }
        return root;
    }

    public static TreeNode successor(TreeNode root){
        TreeNode curr = root.right;
        while (curr != null && curr.left != null)
            curr = curr.left;
        return curr;
    }

}
