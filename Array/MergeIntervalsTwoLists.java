package Leetcode.Array;

import java.util.LinkedList;
import java.util.List;

import Leetcode.Utils.Interval;

public class MergeIntervalsTwoLists {
  // 1:   1，2  4，6  7，12
  // 2:   3，5  5，7  4，9
  //
  public List<Interval> merge(List<Interval> i1, List<Interval> i2) {
    LinkedList<Interval> result = new LinkedList<>();

    int i =0 ;
    int j = 0;
    int len1 = i1.size();
    int len2 = i2.size();

    while(i < len1 || j < len2){
      //add the elements in i1 to the result list
      //case1: l2 reaches the end
      //case2: the interval i points to has smaller start time than that of j points to
      if (j == len2 || i < len1 && i1.get(i).start <= i2.get(j).start) {
        //if it's the first element or there're no overlapping
        if(result.isEmpty() || result.getLast().end < i1.get(i).start){
          result.add(i1.get(i));
        }
        else{
          result.getLast().end = Math.max(i1.get(i).end, result.getLast().end);
        }
        i++;
      }
      //add the elements in l2 to the result list
      else{
        //if it's the first element or there're no overlapping
        if(result.isEmpty() || result.getLast().end < i2.get(j).start){
          result.add(i2.get(j));
        }
        else{
          result.getLast().end = Math.max(i2.get(j).end, result.getLast().end);
        }
        j++;
      }
    }
    return result;
  }

  public static void main(String[] args){
    Interval i1 = new Interval(1,3);
    Interval i2 = new Interval(4,6);
    Interval i3 = new Interval(6,9);
    Interval i4 = new Interval(10,15);
    Interval i5 = new Interval(16,19);
    Interval i6 = new Interval(20,23);

    List<Interval> list1 = new LinkedList<>();
    List<Interval> list2 = new LinkedList<>();
    list1.add(i1);
    list1.add(i3);
    list1.add(i6);
    list2.add(i2);
    list2.add(i4);
    list2.add(i5);

    MergeIntervalsTwoLists obj = new MergeIntervalsTwoLists();
    List<Interval> res = obj.merge(list1, list2);
    for(Interval i : res){
      System.out.println(i.start + " " + i.end);
    }
  }



}
