import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.get(nums[i]) == null) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }
        
        int kind = 0;
        for(Map.Entry<Integer, Integer> pair : map.entrySet()) {
            // System.out.println(pair.getKey() + " " + pair.getValue());
            kind++;
        }
        
        if(nums.length / 2 <= kind) answer = nums.length / 2;
        else answer = kind;
        return answer;
    }
}