package Leetcode.Array;

public class PreviousPermutation {

  public void previousPermutation(int[] nums) {
    int i = nums.length - 2;

    // 1 5 6 10 7 8 9
    // 1 5 6 (10) 7 8  9
    // 1 5 6  9  7  8 10
    // 1 5 6  9 10 8 7
    while(i >= 0 && nums[i] <= nums[i + 1]){
      i--;
    }
    if(i >= 0) {
      int j = nums.length - 1;
      while (j >= 0 && nums[i] <= nums[j]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
  }

  //reverse
  private void reverse(int [] nums, int start){
    int i = start;
    int j = nums.length - 1;

    while(i < j){
      swap(nums,i , j);
      i++;j--;
    }
  }

  //swap
  private void swap(int [] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args){
    PreviousPermutation obj = new PreviousPermutation();
    int[] nums = {1,2,4,3,5};
    obj.previousPermutation(nums);
    for(int i = 0 ; i < nums.length ; i++){
      System.out.print(nums[i] + " ");
    }
  }
}
