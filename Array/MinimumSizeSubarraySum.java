package Leetcode.Array;

public class MinimumSizeSubarraySum {

  public int minSubArrayLen(int s, int[] nums) {
    //corner case
    if(nums.length == 0|| nums == null){
      return 0;
    }

    int min = Integer.MAX_VALUE;
    int currSum = 0;
    int l = 0, r = 0;
    while(r < nums.length ){
      currSum += nums[r++];
      while(currSum >= s && l <= r){
        min = Math.min(min, r - l);
        currSum -= nums[l++];
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }
}
