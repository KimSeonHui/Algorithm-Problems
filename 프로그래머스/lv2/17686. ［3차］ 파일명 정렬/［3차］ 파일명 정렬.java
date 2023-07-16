import java.io.*;
import java.util.*;

class Solution {
    class FileName implements Comparable<FileName> {
        String head;
        String num;
        String tail;
        
        public FileName(String head, String num, String tail) {
            this.head = head;
            this.num = num;
            this.tail = tail;
        }
        
        public int compareTo(FileName file) {
            int r = this.head.toLowerCase().compareTo(file.head.toLowerCase());
            if(r == 0) r = Integer.compare(Integer.parseInt(this.num), Integer.parseInt(file.num));
            return r;
        }
        
        public String toString() {
            // System.out.println(head+ " " + num + " " + tail);
            return head+num+tail;
        }
    }
    
    public String[] solution(String[] files) {
        FileName[] fns = new FileName[files.length];
        for(int i=0; i<files.length; i++) {
            String head = "";
            String num = "";
            String tail = "";
            
            boolean isNumberStarted = false;
            boolean isNumberEnd = false;
            for(int j=0; j<files[i].length(); j++) {
                char ch = files[i].charAt(j);
                if(!isNumberStarted && (ch < '0' || '9' < ch )) head += ch;
                else if(!isNumberEnd && ('0' <= ch && ch <= '9') && num.length() < 5) {
                    isNumberStarted = true;
                    num += ch;
                }
                else if(isNumberStarted) {
                    isNumberEnd = true;
                    tail += ch;
                }
            }
            fns[i] = new FileName(head, num, tail);
        }
        
        Arrays.sort(fns);
        String[] answer = new String[files.length];
        for(int i=0; i<fns.length; i++) {
            answer[i] = fns[i].toString();
        }
        
        return answer;
    }
}