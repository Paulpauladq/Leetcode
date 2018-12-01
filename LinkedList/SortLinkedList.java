package Leetcode.LinkedList;

import Leetcode.Utils.ListNode;

public class SortLinkedList {
  public ListNode sortList(ListNode head) {
    //bottom case
    if(head == null||head.next == null){
      return head;
    }

    //1.cut the list into two halves
    ListNode p1 = head;
    ListNode p2 = head;
    ListNode pre = null;

    //find the middle linked list element
    while(p2 != null && p2.next != null){
      pre = p1;
      p1 = p1.next;
      p2 = p2.next.next;
    }
    pre.next = null;

    //2.sort each half
    ListNode h1 = sortList(head);
    ListNode h2 = sortList(p1);
    //3.merge l1 and l2
    MergeTwoLists mergeObj = new MergeTwoLists();
    return mergeObj.mergeTwoLists(h1,h2);
  }

  public static void main(String args[]){
//    int[] arrTest = new int[]{42,2,23,41,53,26,37,18,9,12};
//    ListNode obj = new ListNode(0);
//    ListNode headTest = obj.createLinkedList(arrTest,arrTest.length);
//    obj.printLinkedList(headTest);
//    SortLinkedList sort = new SortLinkedList();
//    ListNode newHeadTest = sort.sortList(headTest);
//    obj.printLinkedList(newHeadTest);

    int a = 2147483647;
    int b = 3231231;
    long c = (long)a * b;
    System.out.println( c);
  }
}
