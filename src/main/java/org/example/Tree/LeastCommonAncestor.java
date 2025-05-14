package org.example.Tree;

public class LeastCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(12);
        root.right = new TreeNode(21);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(15);

        int key1 = 21;
        int key2 = 15;
        TreeNode lca = findLCA(root, key1, key2);
        if (lca != null) {
            System.out.println("LCA of " + key1 + " and " + key2 + " is: " + lca.key);
        } else {
            System.out.println("LCA not found.");
        }
    }

    public static TreeNode findLCA(TreeNode root, int key1, int key2){
        if(root == null)
            return null;
        if(root.key == key1 || root.key == key2)
            return root;
        TreeNode lca1 = findLCA(root.left, key1, key2);
        TreeNode lca2 = findLCA(root.right, key1, key2);

        if(lca1 != null && lca2 != null)
            return root;
        if(lca1 != null)
            return lca1;
        if(lca2 != null)
            return lca2;
        return null;
    }

}
