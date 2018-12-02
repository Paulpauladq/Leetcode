package Leetcode.BinarySearch;

public class SearchInRotatedSortedArrayII {
  public boolean search(int[] nums, int target) {
    if(nums.length == 0 || nums == null){
      return  false;
    }

    int len = nums.length;
    int start = 0; int end = len - 1;

    while(start <= end){
      int mid = start + (end - start)/2;
      if(nums[mid] == target){
        return true;
      }
      //left part is sorted
      if(nums[mid] > nums[start]){
        if(target >= nums[start] && target < nums[mid]){
          end = mid;
        }
        else{
          start = mid + 1;
        }
      }
      //right part is sorted
      else if(nums[mid] < nums[start]){
        if(target > nums[mid] && target <= nums[end]){
          start = mid + 1;
        }
        else{
          end = mid;
        }
      }
      else{
        start++;
      }

    }
    return false;
  }
}
