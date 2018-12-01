package Leetcode.LinkedList;
import Leetcode.Utils.ListNode;

public class ReversedLinkedList2 {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if(head == null){
      return null;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode start = dummy;


    for(int i = 0 ; i < m -1 ; i++){
      start = start.next;
    }

    ListNode prev = start;
    start = start.next;
    ListNode next = start.next;

    //reverse from m to n
    for(int i = 0 ; i < n- m ; i++){
      start.next = next.next;
      next.next = prev.next;
      prev.next = next;
      next = start.next;
    }

    return dummy.next;
  }
}
