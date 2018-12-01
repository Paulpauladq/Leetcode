package Leetcode.LinkedList;

import Leetcode.Utils.ListNode;

public class MergeTwoLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null){
      return l2;
    }
    if(l2 == null){
      return l1;
    }
    if(l1.val <= l2.val){
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    }
    else{
      l2.next = mergeTwoLists(l2.next,l1);
      return l2;
    }
  }

  //space: O(1)
  //time: O(N + M)  N,M is the length of l1,l2
  public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
    //dummy node
    ListNode dummy = new ListNode(0);
    ListNode iterator = dummy;
    //compare one by one
    while(l1 != null && l2 != null){
      if(l1.val >= l2.val){
        iterator.next = l2;
        l2 = l2.next;
      } else {
        iterator.next = l1;
        l1 = l1.next;
      }
      //pointer move to the next
      iterator = iterator.next;
    }
    //handle the rest of one list
    iterator.next = l1 == null? l2 : l1;
    return dummy.next;
  }
}
