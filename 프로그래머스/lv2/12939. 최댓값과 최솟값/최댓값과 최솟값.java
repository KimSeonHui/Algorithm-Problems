import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        // 1. 공백으로 split
        String[] split = s.split(" ");
        
        // 2. string -> int로 변환
        int[] nums = new int[split.length];
        for(int i=0; i<nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        
        // 3. 오름차순 정렬
        Arrays.sort(nums);
        
        String answer = "";
        answer += nums[0] + " " + nums[nums.length-1]; // 최소 최대
        return answer;
    }
}