package Leetcode.LinkedList;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PhoneDirectory {
  //time: construction O(n)
  //      get          O(1)
  //      check        O(1)
  //      release      O(1)
  //
  //space: O(n) queue, set

  //release need a set to see the removed element
  //keep track of all the removed element

  Deque<Integer> deque = new LinkedList<>();
  Set<Integer> usedSet = new HashSet<>();
  int max;

  /** Initialize your data structure here
   @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
  public PhoneDirectory(int maxNumbers) {
    max = maxNumbers;
    for(int i = 0 ; i < maxNumbers; i++){
      deque.add(i);
    }
  }

  /** Provide a number which is not assigned to anyone.
   @return - Return an available number. Return -1 if none is available. */
  public int get() {
    if(deque.isEmpty()){
      return -1;
    }
    Integer res = deque.poll();
    usedSet.add(res);
    return res;
  }

  /** Check if a number is available or not. */
  public boolean check(int number) {
    if( number >= max || number < 0){
      return false;
    }
    return !usedSet.contains(number);
  }

  /** Recycle or release a number. */
  public void release(int number) {
    if(usedSet.remove(number)){
      deque.add(number);
    }
  }
}
