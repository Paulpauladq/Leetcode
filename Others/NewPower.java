package Leetcode.Others;

public class NewPower {
  public double myPow(double x, int n){
    double powerResult = 1.0;
    long absN = n > 0 ? n : -(long)n;
    while(absN != 0){
      if(absN%2 == 1)
        powerResult *= x;
      x *= x;
      absN /= 2;
    }
    return n >= 0 ? powerResult : 1/powerResult;
  }

  public static void main(String args[]){
    NewPower np = new NewPower();
    System.out.println(-22 % 10);
    System.out.println(np.myPow(2.00, -2147483648));
    System.out.println(np.myPow(2.10, 3));
    System.out.println(np.myPow(2.00, -2));
  }
}
