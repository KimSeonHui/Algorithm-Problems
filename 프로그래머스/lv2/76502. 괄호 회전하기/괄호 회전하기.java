import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] ch = s.toCharArray();
        
        for(int i=0; i<s.length(); i++) {
            // 1. 올바른 괄호 check
            if(check(ch)) answer++;
            
            // 2. 문자열 회전
            rotate(ch);
        }
        
        return answer;
    }
    
    static boolean check(char[] ch) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<ch.length; i++) {
            char c = ch[i];
            // 여는 괄호이면 stack에 추가
            if(c=='[' || c=='{' || c=='(') stack.push(c);
            
            // 닫는 괄호이면
            else if(c==']' || c=='}' || c==')') {
                if(stack.isEmpty()) return false;
                else {
                    char pop = stack.pop();
                    if((pop=='['&&c!=']') || 
                       (pop=='{'&&c!='}') || 
                       (pop=='('&&c!=')')) return false;          
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
    
    static void rotate(char[] ch) {
        char temp = ch[0];
        for(int i=0; i+1<ch.length; i++) {
            ch[i] = ch[i+1];
        }
        ch[ch.length-1] = temp;
    }
}