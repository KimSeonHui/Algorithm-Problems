import java.io.*;
import java.util.*;

class Solution {  
    int N;
    int[] sale = {10, 20, 30, 40};
    int[] res;
    int[] answer = {0, 0};
    
    public int[] solution(int[][] users, int[] emoticons) {        
        N = emoticons.length;
        res = new int[N]; // 중복 순열 결과 저장
        perm(0, users, emoticons); // 중복 순열 
        
        return answer;
    }
    
    public void perm(int cnt, int[][] users, int[] emoticons) {
        if(cnt == N) {
            // System.out.println(Arrays.toString(res));
            
            // 이모티콘별 구매 비용 계산
            calEmoticons(users, emoticons);
            return;
        }
        
        // 10% 20% 30% 40% 이모티콘 별 할인율을 중복 순열로 완전탐색
        for(int i=0; i<sale.length; i++) {
            res[cnt] = sale[i];
            perm(cnt+1, users, emoticons);
        }
    }
    
    public void calEmoticons(int[][] users, int[] emoticons) {
        int join = 0; // 서비스 가입자 수
        int total = 0; // 이모티콘 판매액
        
        for(int i=0; i<users.length; i++) {
            int pay = 0;
            
            for(int j=0; j<emoticons.length; j++) {
                if(users[i][0] <= res[j]) { // 구매 하는 이모티콘 비용 계산
                    pay += emoticons[j] * (100 - res[j]) / 100;
                }
            }
            
            // 구매 비용이 기준 초과 :: 구매 모두 취소, 서비스 가입
            if(pay >= users[i][1]) {
                pay = 0;
                join++;
            }
            total += pay;
        }
        
        // 결과 저장
        if(answer[0] < join) {
            answer[0] = join;
            answer[1] = total;
        }
        else if(answer[0] == join) {
            answer[1] = Math.max(answer[1], total);
        }
    }
}