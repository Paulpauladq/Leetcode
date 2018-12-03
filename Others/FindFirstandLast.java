package Leetcode.Others;

public class FindFirstandLast {
  public int[] searchRange(int [] nums, int target){
    int[] targetRange = {-1, -1};
    int leftIndex = findBoundIndex(nums, target, true);

    if (leftIndex == nums.length || nums[leftIndex] != target){
      return targetRange;
    }
    targetRange[0] = leftIndex;
    targetRange[1] = findBoundIndex(nums, target, false) - 1;

    return targetRange;
  }

  public int findBoundIndex(int[] nums,int target, boolean left){
    int lo = 0;
    int hi = nums.length;

    while(lo < hi){
      int mid =(lo + hi) / 2;
      if(nums[mid] > target || left && nums[mid] == target){
        hi = mid;
      }
      else {
        lo = mid+1;
      }
    }
    return lo;
  }

  public static void main(String args[]){
    FindFirstandLast aaa = new FindFirstandLast();
    int[] array = {1,2,2,2,3,3,3,3,3,4,4,4,5,6,7};
    int[] outputArray = new int[]{};
    outputArray = aaa.searchRange(array, 2);
    System.out.println(outputArray[0] + " " + outputArray[1]);
  }
}
