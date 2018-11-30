package Leetcode.Array;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import Leetcode.Utils.Interval;

public class MergeIntevals {

  //time: O(n logn)
  //space: O(1)
  public List<Interval> merge(List<Interval> intervals) {
    LinkedList<Interval> res = new LinkedList<>();
    if(intervals.size() == 0){
      return res;
    }

    //sort interval list
    Collections.sort(intervals, new Comparator<Interval>(){
      @Override
      public int compare(Interval i1, Interval i2){
        if(i1.start > i2.start){
          return 1;
        } else if(i1.start == i2.start){
          return 0;
        }
        else{
          return -1;
        }
      }
    });

    //merge the overlapping intervals
    for(Interval interval : intervals){
      // if the list of merged intervals is empty or if the current
      // interval does not overlap with the previous, simply append it.
      if(res.isEmpty() || res.getLast().end < interval.start){
        res.add(interval);
      }
      // otherwise, there is overlap, so we merge the current and previous
      // intervals.
      else{
        res.getLast().end = Math.max(res.getLast().end, interval.end);
      }
    }
    return res;
  }
}
