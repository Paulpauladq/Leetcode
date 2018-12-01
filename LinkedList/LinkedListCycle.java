package Leetcode.LinkedList;

import Leetcode.Utils.ListNode;

public class LinkedListCycle {
  public boolean hasCycle(ListNode head) {
    //1.null linked list -- no cycle
    if(head == null || head.next == null){
      return false;
    }
    //2.set up two iterator: slow and fast
    //2.1 fast reaches null -- no cycle
    //2.2 fast catch up slow -- has cycle
    ListNode slow = head;
    ListNode fast = head.next;

    while(fast != slow){
      if(fast == null || fast.next == null){
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }
  public static void main(String args[]){
    int[] arrTest = new int[]{1,2,3,4,5,6,7,8,9};
    ListNode obj = new ListNode(0);
    ListNode headTest = obj.createLinkedList(arrTest,arrTest.length);
    obj.printLinkedList(headTest);
    LinkedListCycle cycleTest = new LinkedListCycle();
    System.out.println(cycleTest.hasCycle(headTest));
  }

}
