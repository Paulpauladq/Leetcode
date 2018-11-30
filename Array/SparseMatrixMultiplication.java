package Leetcode.Array;

public class SparseMatrixMultiplication {
  public int[][] multiply(int[][] A, int[][] B) {
    if(A == null || B == null){
      return null;
    }
    int Ax = A.length; int Ay = A[0].length;
    int By = B[0].length;
    int[][] res = new int[Ax][By];
    if(A.length == 0 || B.length == 0){
      return res;
    }
    for(int i = 0; i < Ax; i++){
      for(int j = 0 ; j < Ay; j++){
        if(A[i][j] != 0){
          for(int k = 0 ; k < By; k++){
            if(B[j][k] != 0){
              res[i][k] += A[i][j] * B[j][k];
            }
          }
        }
      }
    }
    return res;
  }
}
