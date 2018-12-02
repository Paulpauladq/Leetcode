package Leetcode.BinarySearch;

public class FindFirstandLastPositionOfElementinSortedArray {
  //time: O(logn), binary search twice
  //space: O(1), in place
  public int[] searchRange(int[] nums, int target) {
    int[] targetRange = {-1, -1};
    int leftIndex = findBoundIndex(nums, target, true);

    // assert that `leftIdx` is within the array bounds and that `target`
    // is actually in `nums`.
    if (leftIndex == nums.length || nums[leftIndex] != target) {
      return targetRange;
    }

    targetRange[0] = leftIndex;
    targetRange[1] = findBoundIndex(nums, target, false) - 1;

    return targetRange;
  }

  private int findBoundIndex(int[] nums, int target, boolean left) {
    int lo = 0;
    int hi = nums.length;

    while (lo < hi) {
      int mid = (lo + hi) / 2;
      //if left is true: find the first
      //  - the first condition is :   nums[mid] >= target
      //(find the first match)

      //0 1 2 3 4 5
      //1 2 5 5 5 9

      //if left is false: find the last
      //  - the first condition is : nums[mid] > target (find the last match)
      if (nums[mid] > target || left && nums[mid] == target) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }
}
