package Leetcode.BinarySearch;

public class DivideTwoIntegers {

  //overflow
  //dividend == 0
  //divisor == 0
  //+ -

  //regular
  public int divide(int dividend, int divisor){
    boolean isNegative = (dividend < 0 && divisor > 0
            || dividend > 0 && divisor < 0);

    long ldividend = Math.abs((long)dividend);
    long ldivisor = Math.abs((long)divisor);

    if(ldividend == 0){
      return 0;
    }
    if(ldivisor == 0){
      return ldividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    if(dividend == Integer.MIN_VALUE && divisor == -1){
      return Integer.MAX_VALUE;
    }

    int ans = 0;
    long lans = longDivide(ldividend, ldivisor);
    //overflow
    if(lans > Integer.MAX_VALUE){
      ans =  isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
    else{
      ans =  isNegative ? -1 * (int)lans : (int)lans;
    }
    return ans;
  }

  private long longDivide(long longDividend, long longDivisor){

    //exit case
    if(longDivisor > longDividend)
      return 0;

    long sum = longDivisor;
    int multiple = 1;

    //  Find the largest multiple so that (divisor * multiple <= dividend),
    //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
    //  Think this as a binary search.

    while((sum + sum) <= longDividend ){
      sum += sum;
      multiple += multiple;
    }
    return multiple + longDivide(longDividend - sum, longDivisor);
  }
}
