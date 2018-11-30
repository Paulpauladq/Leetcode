package Leetcode.Array;

public class ProductExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int length = nums.length;
    int[] outputArr = new int[length];

    outputArr[0]  = 1;
    // from left to right
    for(int i = 1; i < length ; i++){
      outputArr[i] = outputArr[i - 1] * nums[i - 1];
    }

    //from right to left
    int right = 1;
    for(int i = length - 1 ; i >= 0 ; i--){
      outputArr[i] *= right;
      right *= nums[i];
    }

    return outputArr;
  }
}
