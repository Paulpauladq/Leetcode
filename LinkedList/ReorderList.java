package Leetcode.LinkedList;

import Leetcode.Utils.ListNode;

public class ReorderList {
  public void reorderList(ListNode head) {
      if(head == null|| head.next == null){
        return;
      }
      ListNode middle = findMiddle(head);
      ListNode tail = reverse(middle.next);
      middle.next = null;
      merge(head, tail);
  }

  private ListNode findMiddle(ListNode head){
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  private void merge(ListNode head1, ListNode head2) {
    int index = 0;
    ListNode dummy = new ListNode(0);
    ListNode iterator = dummy;

    while (head1 != null && head2 != null) {
      if (index % 2 == 0) {
        iterator.next = head1;
        head1 = head1.next;
      } else {
        iterator.next = head2;
        head2 = head2.next;
      }
      index++;
      iterator = iterator.next;
    }
    if (head1 != null) {
      iterator.next = head1;
    } else {
      {
        iterator.next = head2;
      }

    }
  }
  private ListNode reverse(ListNode head){
    ListNode newHead = null;
    while(head != null){
      ListNode temp = head.next;
      head.next = newHead;
      newHead = head;
      head = temp;
    }
    return newHead;
  }
}
