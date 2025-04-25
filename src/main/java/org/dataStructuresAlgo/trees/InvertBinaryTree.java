package org.dataStructuresAlgo.trees;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
      }
}

public class InvertBinaryTree {

      public TreeNode invertTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while(!queue.isEmpty()) {
                  TreeNode current = queue.poll();
                  TreeNode temp = current.left;
                  current.left = current.right;
                  current.right = temp;
                  if(current.left !=null) queue.add(current.left);
                  if(current.right !=null) queue.add(current.right);
                  
            }
            return root;
      }

      public static void main(String[] args) {
            InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
            TreeNode root = new TreeNode();
            root.val = 4;
            root.left = new TreeNode();
            root.left.val = 2; 
            root.right = new TreeNode();
            root.right.val = 7;

            
            invertBinaryTree.invertTree(root);
      }
}
