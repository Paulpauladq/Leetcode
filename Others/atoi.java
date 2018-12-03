package Leetcode.Others;

public class atoi {
  public int myAtoi(String str) {
    int index = 0;
    int numTotal = 0;
    int sign = 1;

    //check empty
    if (str.length() == 0)
      return 0;
    //remove spaces
    while (str.charAt(index) == ' ' && index < str.length()) {
      if (index == str.length()-1)
        return 0;
      index++;
    }

    //handle signs
    if (str.charAt(index) == '+' || str.charAt(index) == '-' && index < str.length()) {
      sign = str.charAt(index) == '+' ? 1 : -1;
      index++;
    }

    //convert to numbers
    while (index < str.length()) {
      int digit = str.charAt(index) - '0';
      if (digit < 0 || digit > 9)
        break;
      if (sign == 1 && (numTotal > Integer.MAX_VALUE / 10 || numTotal == Integer.MAX_VALUE / 10 &&
              digit > Integer.MAX_VALUE % 10))
        return Integer.MAX_VALUE;
      if(sign == -1 && (numTotal > Integer.MAX_VALUE / 10 || numTotal == Integer.MAX_VALUE / 10 &&
              digit > Integer.MAX_VALUE % 10 + 1))
        return Integer.MIN_VALUE;

      numTotal = numTotal * 10 + digit;
      index++;
    }
    return sign * numTotal;
  }

  public static void main(String args[]){
    atoi atoiTest = new atoi();
    String str1 = new String("2147483647");
    String str2 = new String("--------12321");
    String str3 = new String("-2147483649");
    String str4 = new String("-2147483648");
    String str5 = new String("-1232sdfkjsdhfkjdshfkjs");
    String str6 = new String("2147483648");

    System.out.println(atoiTest.myAtoi(str1));
    System.out.println(atoiTest.myAtoi(str2));
    System.out.println(atoiTest.myAtoi(str3));
    System.out.println(atoiTest.myAtoi(str4));
    System.out.println(atoiTest.myAtoi(str5));
    System.out.println(atoiTest.myAtoi(str6));
  }
}
