import java.io.*;
import java.util.*;

class Solution {
    static boolean[] v;
    static int N;
    static Set set;
    public int solution(String numbers) {
        N = numbers.length();
        v = new boolean[N];
        set = new HashSet();
        String[] nums = numbers.split("");
        
        perm(0, nums, "");
        Iterator it = set.iterator();
        int ans = 0;
        while(it.hasNext()) {
            if(isPrime((int)it.next())) ans++;
        }
        
        return ans++;
    }
    
    public void perm(int cnt, String[] nums, String made) {
        //System.out.println("made " + made);
        //System.out.println(Arrays.toString(v));
        if(made != "" && made.charAt(0) != '0') {
            set.add(Integer.parseInt(made));
        }
        if(cnt == N) {
            return;
        }
        
        for(int i=0; i< nums.length; i++) {
            if(v[i]) continue;
            
            v[i] = true;
            perm(cnt+1, nums, made+nums[i]);
            v[i] = false;
        }
    }
    
    public boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i=2; i*i<=num; i++) {
            for(int j=i; j<=num; j+=i) if(num == j) return false;
        }
        return true;
    }
}