package Leetcode.LinkedList;

import Leetcode.Utils.ListNode;

public class PlusOneLinkedList {
  //time: O(n)  go thru list at most twice
  //space: O(1) only need temp pointers

  //two pointers: j: find the last digit,
  //i: find the last digit if the following is all 9s(handle the carry case)
  private static final int HIGHESTDIGIT = 9;
  public ListNode plusOne(ListNode head) {
    if(head == null){
      return null;
    }
    //dummy: handle the carry
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode i = dummy;
    ListNode j = dummy;

    //move j to the least sigificant digit
    while(j.next != null){
      j = j.next;
      //move i to the digit needed to be carried, if not i = j
      if(j.val != HIGHESTDIGIT){
        i = j;
      }
    }

    //update the digit
    if( j.val != HIGHESTDIGIT){
      j.val++;
    } else {
      i.val++;
      i = i.next;
      while(i != null){
        i.val = 0;
        i = i.next;
      }
    }

    //return dummy to handle case like 999 - 1000
    return dummy.val == 0 ? dummy.next : dummy;
  }
}
