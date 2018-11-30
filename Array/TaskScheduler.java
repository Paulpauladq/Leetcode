package Leetcode.Array;

import java.util.Arrays;

public class TaskScheduler {
  public int leastInterval(char[] tasks, int n) {
    char[] arr = new char[26];
    for(char task: tasks){
      arr[task - 'A']++;
    }

    int maxFreq = 0;
    Arrays.sort(arr);
    for(int i = 0 ; i < 26 ; i++){
      if(arr[i] == arr[25]){
        maxFreq++;
      }
    }

    return Math.max(tasks.length, (n + 1) * (arr[25] - 1) + maxFreq);
  }

}
