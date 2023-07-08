class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int rightCnt = 0;
        int undefinedCnt = 0;
        
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i]==0) undefinedCnt++;
            else {
                if(find(lottos[i], win_nums))  rightCnt++;
            }
        }
        
        int max = rightCnt + undefinedCnt;
        int min = rightCnt;
        
        int[] answer = {getRank(max), getRank(min)};
        return answer;
    }
    
    static boolean find(int num, int[] win_nums) {
        boolean isFind = false;
        for(int i=0; i<win_nums.length; i++) {
            if(num == win_nums[i]) isFind = true;
        }
        return isFind;
    }
    
    static int getRank(int cnt) {
        if(cnt == 6) return 1;
        else if(cnt == 5) return 2;
        else if(cnt == 4) return 3;
        else if(cnt == 3) return 4;
        else if(cnt == 2) return 5;
        else  return 6;
    }
}