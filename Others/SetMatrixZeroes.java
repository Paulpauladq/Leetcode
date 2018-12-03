package Leetcode.Others;

public class SetMatrixZeroes {
  /**
   * dffffffffff
   * dffffffffffff
   * @param matrix
   */
  public void setZeroes(int[][] matrix) {
    boolean isFirstRowZeros = false;
    boolean isFirstColZeros = false;

    int lineNumber = matrix.length;
    int colNumber = matrix[0].length;
    //1.judge first row and first column boolean
    for(int i = 0; i < lineNumber ; i++){
      if(matrix[i][0] == 0){
        isFirstColZeros = true;
        break;
      }
    }

    for(int i = 0; i < colNumber ; i++){
      if(matrix[0][i] == 0){
        isFirstRowZeros = true;
        break;
      }
    }
    //2.use first row and column to mark zero row and column
    for(int i = 1; i < lineNumber; i++){
      for(int j = 1; j < colNumber ; j++){
        if(matrix[i][j] == 0){
          //set first col mark
          matrix[i][0] = 0;
          //set first row mark
          matrix[0][j] = 0;
        }
      }
    }

    //3.set each elements by using marks in first row and column
    for(int i = 1; i < lineNumber; i++){
      for(int j = 1; j < colNumber ; j++){
        if(matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    //4.set first column and row by using marks in step 1
    if(isFirstRowZeros){
      for(int i = 0 ; i < colNumber ; i++){
        matrix[0][i] = 0;
      }
    }
    if(isFirstColZeros){
      for (int j = 0; j < lineNumber ; j++){
        matrix[j][0] = 0;
      }
    }
  }

  public static void main(String args[]){
    SetMatrixZeroes test = new SetMatrixZeroes();
    int[][] test2DArr = new int[6][10];
    for(int i = 0; i < test2DArr.length ;i++){
      for(int j = 0; j < test2DArr[0].length ; j++){
        test2DArr[i][j] = i - j;
      }
    }
    for(int i = 0; i < test2DArr.length ;i++){
      for(int j = 0; j < test2DArr[0].length ; j++){
        System.out.print(test2DArr[i][j] + " ");
      }
      System.out.print("\n");
    }
    System.out.println("*******************");
    test.setZeroes(test2DArr);
    for(int i = 0; i < test2DArr.length ;i++){
      for(int j = 0; j < test2DArr[0].length ; j++){
        System.out.print(test2DArr[i][j] + " ");
      }
      System.out.print("\n");
    }
  }
}
