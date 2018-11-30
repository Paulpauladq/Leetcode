package Leetcode.Array;

public class KthLargestElementInAnArray {
  public int findKthLargest(int[] nums, int k){
    //null empty case
    if(nums == null || nums.length == 0){
      return Integer.MAX_VALUE;
    }
    return findKthLargestHelper(nums, 0, nums.length - 1, nums.length - k);
  }

  private int findKthLargestHelper(int[] nums, int start, int end, int k){
    if(start > end)
      return Integer.MAX_VALUE;


    int pivot = nums[end];
    int left = start;

    //put the element smaller than pivot to the left
    for(int i = start ; i< end ; i++ ){
      if(nums[i] <= pivot){
        swapElement(nums, left++, i);
      }
    }
    swapElement(nums, left, end);
    if(left == k){
      return nums[left];
    }
    else if(left < k){
      return findKthLargestHelper(nums, left+1,end, k);
    }
    else{
      return findKthLargestHelper(nums,start, left - 1, k);
    }
  }

  private void swapElement(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
