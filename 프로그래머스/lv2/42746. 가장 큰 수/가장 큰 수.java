import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] sNumbers = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            sNumbers[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(sNumbers, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return -(o1+o2).compareTo(o2+o1);
            } 
        });
        // System.out.println(Arrays.toString(sNumbers));
        for(String num : sNumbers) answer += num;
        if(answer.charAt(0) == '0') answer = "0";
        return answer;
    }
}