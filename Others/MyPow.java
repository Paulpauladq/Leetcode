package Leetcode.Others;

import java.util.*;
import java.lang.*;

public class MyPow {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDivList= new ArrayList();
        for(int i = left ; i <= right; i++){
            if(isSelfDividing(i))
                selfDivList.add(i);
        }
        return selfDivList;
    }

    //judge self-dividing
    public boolean isSelfDividing(int input){
        int temp = input;
        while(temp > 0){
            int digit = temp%10;
            temp /= 10;
            if(temp == 0|| (input % temp != 0)) return false;
        }
        return true;
    }
}
