package Leetcode.Array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] num) {
    //sort first
    Arrays.sort(num);
    List<List<Integer>> res = new LinkedList<>();
    //traverse the array from 0 - (length - 2)
    for(int i = 0; i < num.length - 2 ; i++){
      if(i == 0 || i > 0 && num[i] != num[i-1] ){

        //two pointer to find other two elements
        int low = i + 1;
        int high = num.length - 1;
        int sum = 0 - num[i];

        //use two pointer to find the other two whose sum equals 0 - element1
        while(low < high){
          if(num[low] + num[high] == sum){
            res.add(Arrays.asList(num[low], num[high], num[i]));
            //pass by the same element
            while(low < high && num[low] == num[low + 1]){
              low ++;
            }
            //pass by the same element
            while(low < high && num[high] == num[high - 1]){
              high --;
            }
            low ++;
            high --;
          }
          else if(num[low] + num[high] < sum){
            low ++;
          }
          else{
            high --;
          }
        }
      }
    }

    return res;
  }
}
