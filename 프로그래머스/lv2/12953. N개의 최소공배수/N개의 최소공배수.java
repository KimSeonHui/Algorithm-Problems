import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        if(arr.length < 2) return arr[0];
        
        int answer =  arr[0] * arr[1] / gcd(arr[0], arr[1]);
        if(arr.length > 2) {
            for(int i=2; i<arr.length; i++) {
                answer = answer * arr[i] / gcd(answer, arr[i]);
            }
        }
        return answer;
    }
    
    public int gcd(int a, int b) {
        if(a > b) {
            int c = a % b;
            if(c == 0) return b;
            else return gcd(b, c);
        }
        else {
            int c = b % a;
            if(c == 0) return a;
            else return gcd(a, c);
        }
    }
}