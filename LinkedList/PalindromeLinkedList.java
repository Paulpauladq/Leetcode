package Leetcode.LinkedList;

import Leetcode.Utils.ListNode;

public class PalindromeLinkedList {
  //time: O(n) visit each node at most twice
  //space: O(1) extra space for ListNode
  public boolean isPalindrome(ListNode head) {
    //1) Use fast and slow pointers to find the middle element
    //2) reverse the second part of the linked list
    //3) compare and update the two pointers

    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }

    //when the linked list contains odd number features
    //we make second half shorter
    if(fast != null){
      slow = slow.next;
    }

    //reverse the second half
    slow = reverse(slow);

    //compare
    while(slow != null){
      if(head.val != slow.val){
        return false;
      }
      slow = slow.next;
      head = head.next;
    }
    return true;
  }

  //reverse helper
  private ListNode reverse(ListNode head){
    ListNode pre = null;
    ListNode curr = head;
    ListNode next;

    while(curr != null){
      next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }
    return pre;
  }
}
