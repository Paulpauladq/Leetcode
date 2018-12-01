package Leetcode.LinkedList;

import Leetcode.Utils.ListNode;

public class AddTwoNumber {
  //time: O(max(m , n)) m n is the length
  //space: O(max(m, n)) m n is the length
  //special cases:
  // 1) 122 + 1 = 123
  // 2) 99 + 1 = 100
  // 3) null + 10 = 10
  private static final int BASE = 10;
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode dummy = new ListNode(0);
    ListNode p = l1;
    ListNode q = l2;
    ListNode curr = dummy;
    int carry = 0;

    while(p != null || q != null){
      //add two digits if not null
      int x = (p != null) ? p.val : 0;
      int y = (q != null) ? q.val : 0;

      //remeber to add the previous carry
      int sum = carry + x + y;

      carry = sum / BASE;
      curr.next = new ListNode(sum % BASE);

      //update 3 iterators
      curr = curr.next;
      if(p != null)
        p = p.next;
      if(q != null)
        q = q.next;
    }

    if(carry != 0){
      curr.next = new ListNode(carry);
    }
    return dummy.next;
  }
}
