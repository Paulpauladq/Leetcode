package Leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
  //decide the index of left index
  //the right boundary of the left index is arr.length - k
  //so we do binary search in the range of 0, n - k

  //1           2          3                     4
  //0...........M....| ...M + k ................n - k
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();
    int len = arr.length;
    int l = 0;
    int r = len - k;

    //main pass of bs
    while(l < r){
      int mid = l + (r - l) / 2;
      //if x is in the Range 2-4 , the left bound is not sure.
      if(x > arr[mid]){

        if(x - arr[mid] > arr[mid + k] - x){
          l = mid + 1;
        }
        else{
          r = mid;
        }
      }
      //if x is in the Range 1-2 , the left bound is also in the Range 1-2
      else{
        r = mid;
      }
    }
    for(int i = l; i <= l + k - 1; i++ ){
      result.add(arr[i]);
    }
    return result;
  }
}
