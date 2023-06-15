import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        //System.out.println(Arrays.toString(phone_book));
        
        for(int i=0; i+1<phone_book.length; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) answer = false;
        }
        
        return answer;
    }
}