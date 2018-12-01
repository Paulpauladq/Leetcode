package Leetcode.LinkedList;

import Leetcode.Utils.ListNode;

public class GetIntersectionNode {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null){
      return null;
    }
    ListNode p1 = headA;
    ListNode p2 = headB;

    //*********two pointers solution************
    while(p1 != p2) {
      p1 = p1 == null ? headB : p1.next;
      p2 = p2 == null ? headA : p2.next;
    }
    return p1;
  }
}
