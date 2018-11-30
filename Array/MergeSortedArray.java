package Leetcode.Array;

public class MergeSortedArray {
  public void merge(int[] A, int m , int[] B, int n){
    int[] resultArr = new int[m + n];
    int AIndex = 0;
    int BIndex = 0;
    int resIndex = 0;
    while(AIndex < m && BIndex < n){
      if(A[AIndex] < B[BIndex]){
        resultArr[resIndex++] = A[AIndex++];
      }
      else{
        resultArr[resIndex++] = B[BIndex++];
      }
    }

    while(AIndex < m){
      resultArr[resIndex++] = A[AIndex++];
    }

    while(BIndex < n){
      resultArr[resIndex++] = B[BIndex++];
    }
    for(int i = 0 ; i< A.length ; i++){
      A[i] = resultArr[i];
    }
  }
}
