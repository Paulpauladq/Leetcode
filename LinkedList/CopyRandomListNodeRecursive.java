package Leetcode.LinkedList;

import java.util.HashMap;

public class CopyRandomListNodeRecursive {

  HashMap<RandomListNode, RandomListNode> visitedHash =
          new HashMap<RandomListNode,RandomListNode>();

  public RandomListNode copyRandomList(RandomListNode head) {
    if(head == null){
      return null;
    }
    if(this.visitedHash.containsKey(head)){
      return this.visitedHash.get(head);
    }

    RandomListNode newNode = new RandomListNode(head.label);
    this.visitedHash.put(head, newNode);

    newNode.next = this.copyRandomList(head.next);
    newNode.next = this.copyRandomList(head.random);

    return newNode;
  }
}


