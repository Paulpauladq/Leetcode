package Leetcode.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

import Leetcode.Utils.ListNode;

//time: O(N logk) k = lists.length, N = number of nodes
//log k: comparsion operation
//space: O(1) link em ,don't need auxiliary space
public class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    //corner case
    if(lists == null || lists.length == 0){
      return null;
    }

    //priority queue to compare one by one
    PriorityQueue<ListNode> comparisonQueue = new PriorityQueue<ListNode>(lists.length,
            new Comparator<ListNode>(){
      @Override
      public int compare(ListNode node1, ListNode node2){
        if(node1.val > node2.val)
          return 1;
        else if(node1.val == node2.val){
          return 0;
        }
        else{
          return -1;
        }
      }
    });

    //and every head into the pq
    for(ListNode node : lists){
      if(node != null){
        comparisonQueue.add(node);
      }
    }

    //set dummy
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    //poll the smallest from the comparison pool and connect it to the linked list
    while(!comparisonQueue.isEmpty()){
      curr.next = comparisonQueue.poll();
      curr = curr.next;

      if(curr.next != null){
        comparisonQueue.add(curr.next);
      }
    }
    return dummy.next;
  }
}
