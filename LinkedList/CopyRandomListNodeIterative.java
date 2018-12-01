package Leetcode.LinkedList;

import java.util.HashMap;

public class CopyRandomListNodeIterative {
  //old node reference as "key" and
  // new node reference as the "value"
  HashMap<RandomListNode,RandomListNode> visited =
          new HashMap<RandomListNode,RandomListNode>();

  public RandomListNode getCloneNode(RandomListNode node){
    if(node != null){
      if(this.visited.containsKey(node)){
        return this.visited.get(node);
      }
      else {
        this.visited.put(node, new RandomListNode(node.label));
        return this.visited.get(node);
      }
    }
    return null;
  }

  public RandomListNode copyRandomList(RandomListNode head){

    //head == null
    if(head == null)
      return head;
    //create the new head node

    RandomListNode oldNode = head;
    RandomListNode newNode = new RandomListNode(oldNode.label);
    this.visited.put(oldNode, newNode);

    //Iterate on the linked list until all nodes are cloned
    while(oldNode != null){
      newNode.next = this.getCloneNode(oldNode.next);
      newNode.random = this.getCloneNode(oldNode.random);

      oldNode = oldNode.next;
      newNode = newNode.next;
    }
    return this.visited.get(head);
  }
}
