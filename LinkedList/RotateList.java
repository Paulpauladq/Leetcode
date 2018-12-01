package Leetcode.LinkedList;

import Leetcode.Utils.ListNode;

public class RotateList {
  //idea: find the offset, rotate the linkedlist
  //time:O(n) one-pass to find the length, O(1) to rotate
  //space: O(1) two pointers
  public ListNode rotateRight(ListNode head, int k) {
    //corner case
    if(head == null || head.next == null){
      return head;
    }

    //initialize dummy
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = dummy;

    //find the length of the linked list
    int length = 0;
    while(fast.next != null){
      fast = fast.next;
      length++;
    }

    //calculate the rotate point
    int pivot = length - k % length;
    for(int i = 0 ; i < pivot; i++){
      slow = slow.next;
    }

    //rotate operation
    fast.next = dummy.next;
    dummy.next = slow.next;
    slow.next = null;

    return dummy.next;
  }
}
