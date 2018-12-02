package Leetcode.BinarySearch;

public class SearchA2DArray {
  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix == null || matrix.length == 0){
      return false;
    }
    //treat it as a sorted array and search it
    int rowLen = matrix.length;
    int colLen = matrix[0].length;

    int l = 0; int r = rowLen * colLen -1;

    while(l <= r){
      int mid = l + (r - l) /2;
      int midVal = matrix[mid / colLen][mid % colLen];
      if(midVal == target){
        return true;
      }
      else if(midVal > target){
        r = mid - 1;
      }
      else{
        l = mid + 1;
      }
    }
    return false;
  }
}
