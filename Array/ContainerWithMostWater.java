package Leetcode.Array;

public class ContainerWithMostWater {
  public int maxArea(int[] height) {

    int maxArea = 0;
    int length = height.length;

    int lo = 0;
    int hi = length - 1;
    while(lo < hi){
      maxArea = Math.max(maxArea,
              Math.min(height[lo], height[hi]) * (hi - lo));
      if(height[lo] < height[hi]){
        lo++;
      }
      else{
        hi --;
      }
    }

    return maxArea;

  }
}
