package Leetcode.Array;

public class SubarrayProductLessThanK {

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if(k <= 1) return 0;
    //using sliding window
    int prod = 1;
    int count = 0;
    int left = 0, right = 0;
    int length = nums.length;

    for(right = 0 ; right < length; right++){
      prod *= nums[right];
      while(prod >= k){
        prod /= nums[left++];
      }
      count += right - left + 1;
    }
    return count;
  }
}
