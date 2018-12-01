package Leetcode.LinkedList;

import Leetcode.Utils.ListNode;

public class OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    //idea: separate the orginal linked list into two and merge at last
    //time: O(n) time, visit each node once
    //space: O(1) space, no extra space

    //corner case
    if(head == null || head.next == null){
      return head;
    }
    //initialize
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;

    //if the length is odd number, even pointer will be at the null element
    //if the length is even number, even pointer will be at the last element
    while(even != null && even.next != null){
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }

    //merge the odd list and even list
    odd.next = evenHead;
    return head;
  }
}
