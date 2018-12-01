package Leetcode.LinkedList;

import Leetcode.Utils.Node;


public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
  private Node prev = null;
  public Node treeToDoublyList(Node root) {

    if(root == null)
      return null;

    Node dummy = new Node(0, null, null);
    prev = dummy;
    inorderTraversal(root);

    //connect the head and tail
    prev.right = dummy.right;
    dummy.right.left = prev;

    return dummy.right;

  }

  //inorder traversal
  private void inorderTraversal(Node curr){
    if(curr == null){
      return;
    }
    inorderTraversal(curr.left);

    //connect the prev and curr
    prev.right = curr;
    curr.left = prev;
    prev = curr;

    inorderTraversal(curr.right);
  }
}
