package Leetcode.BinarySearch;

public class SearchA2DArrayII {
  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix == null|| matrix.length == 0){
      return false;
    }

    int rowLen = matrix.length;
    int colLen = matrix[0].length;

    //start the top right
    int row = 0;
    int col = colLen - 1;

    while(col >= 0 && row <= rowLen - 1){
      int val = matrix[row][col];
      if(val == target){
        return true;
      }
      else if(val > target){
        col--;
      }
      else{
        row++;
      }
    }
    return false;
  }
  //O(m+n)
}
