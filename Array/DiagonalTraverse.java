package Leetcode.Array;

public class DiagonalTraverse {
  public int[] findDiagonalOrder(int[][] matrix) {
    if(matrix == null || matrix.length == 0){
      return new int[0];
    }
    int rowNum = 0;
    int colNum = 0;
    int rowLength = matrix.length;
    int colLength = matrix[0].length;

    int[] arr = new int[rowLength * colLength];


    for(int i = 0 ; i < arr.length ; i++){
      arr[i] = matrix[rowNum][colNum];

      //up
      if((rowNum + colNum) % 2 == 0){
        System.out.print("x");
        if(colNum == colLength - 1){
          rowNum++;
        }
        else if(rowNum == 0){
          colNum++;
        }
        else{
          colNum++;
          rowNum--;
        }
      }

      else{
        if(rowNum == rowLength - 1){
          colNum++;
        }
        else if(colNum == 0){
          rowNum++;
        }
        else{
          rowNum++;
          colNum--;
        }
      }
    }
    return arr;
  }
}
