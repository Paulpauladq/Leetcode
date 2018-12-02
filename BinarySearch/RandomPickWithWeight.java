package Leetcode.BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickWithWeight {
  private List<Integer> psum = new ArrayList<>();
  private int sum = 0;
  Random rand = new Random();

  public RandomPickWithWeight(int[] w) {
    for(int weight : w){
      sum += weight;
      psum.add(sum);
    }

  }

  public int pickIndex() {
    int target = rand.nextInt(sum);

    int lo = 0;
    int hi = psum.size() - 1;

    while(lo < hi){
      int mid = lo + (hi - lo)/2;
      if(target >= psum.get(mid)){
        lo = mid + 1;
      }
      else{
        hi = mid;
      }
    }
    return lo;

  }
}
