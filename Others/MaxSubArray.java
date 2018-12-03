package Leetcode.Others;

public class MaxSubArray {
  public int maxSubArray(int array[]){
    int newSum =  0;
    int max = array[0];

    for(int i = 0; i < array.length ; i++){
      newSum = Math.max(newSum + array[i], array[i]);
      max = Math.max(max, newSum);
    }
    return max;
  }
  public static void main(String args[]){
    MaxSubArray msa = new MaxSubArray();
    int[] arrayTest = new int[]{1};
    System.out.println(msa.maxSubArray(arrayTest));
  }
}
