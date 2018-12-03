package Leetcode.Others;

public class ZigzagConversion {
  public String ZigZag(String s, int numRows) {
    if(numRows == 1){
      return s;
    }
    StringBuffer sb = new StringBuffer();
    int length = s.length();
    int cycle = 2 * numRows - 2;

    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j + i < length; j += cycle) {
        sb.append(s.charAt(j + i));
        if (i != 0 && i != numRows - 1 && j + cycle - i < length)
          sb.append(s.charAt(j + cycle - i));
      }
    }
  return sb.toString();
  }

  public static void main(String args[]){
    ZigzagConversion zigzagTest = new ZigzagConversion();
    String s1 = "PAYPALISHIRING";
    String outputString = zigzagTest.ZigZag(s1, 4);
    System.out.println(outputString);
  }
}
