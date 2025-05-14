package org.example.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    static Queue<TreeNode> queue = new LinkedList<>() {
    };

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        System.out.println("Level order traversal of the binary tree:");
        levelOrderTraversal(root);

        System.out.println("\nLevel order traversal of the binary tree level wise:");
        levelOrderTraversalPrintLevelwise(root);
    }

    public static void levelOrderTraversal(TreeNode root){
        if(root != null){
            queue.add(root);
            int count = 0;
            while(!queue.isEmpty()){
                count = queue.size();
                for(int i=0;i<count;i++){
                    TreeNode curr = queue.poll();
                    System.out.print(curr.key +" ");
                    if(curr.left != null)
                        queue.add(curr.left);
                    if(curr.right != null)
                        queue.add(curr.right);
                }
            }
        }
    }

    public static void levelOrderTraversalPrintLevelwise(TreeNode root){
        if(root != null){
            queue.add(root);
            queue.add(null);
            int count = 0;
            while(queue.size() > 1){
                    TreeNode curr = queue.poll();
                    if(curr == null){
                        System.out.println();
                        queue.add(null);
                        continue;
                    }
                    System.out.print(curr.key +" ");
                    if(curr.left != null)
                        queue.add(curr.left);
                    if(curr.right != null)
                        queue.add(curr.right);
            }
        }
    }

}
