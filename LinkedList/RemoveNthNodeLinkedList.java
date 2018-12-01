package Leetcode.LinkedList;

import Leetcode.Utils.ListNode;

public class RemoveNthNodeLinkedList {
  /**
   * !@#$%^&*(*&^%$#@#$%^&*&^%$#@#$%^&*
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    //remove (L-n+1)th element of the linked list
    //create dummy head to prevent null linked list
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    //calculate L's length by traversing the linked list
    int length = 0;
    ListNode first = head;

    while(first != null){
      length++;
      first = first.next;
    }

    //find (L-n+1)th element
    length -= n;
    first = dummy;

    while(length > 0){
      length--;
      first = first.next;
    }

    //remove (node.next = node.next.next)
    first.next = first.next.next;
    return dummy.next;
  }

  public static void main(String args[]){
    int[] arrTest = new int[]{1,2,3,4,5,6,7,8,9};
    ListNode obj = new ListNode(0);
    ListNode headTest = obj.createLinkedList(arrTest,arrTest.length);
    obj.printLinkedList(headTest);
    RemoveNthNodeLinkedList obj1 = new RemoveNthNodeLinkedList();
    obj1.removeNthFromEnd(headTest, 5);
    obj.printLinkedList(headTest);
  }
}
