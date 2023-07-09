class Solution {
    public int[] solution(int n) {
        int[][] map = new int[n][n];
        int[] dr = {1,0,-1}; // 하우좌상
        int[] dc = {0,1,-1}; // 하우좌상
        
        // 1. 삼각형 채우기
        int num=1;
        int r=0, c=0, d=0;
        while(num <= n*(n+1)/2) {
            map[r][c] = num++;
            
            int nr = r+dr[d];
            int nc = c+dc[d];
            
            // 배열 범위 벗어나거나, 이미 숫자가 채워져 있으면>> 방향 전환
            if(nr<0 || n<=nr || nc<0 || n<=nc || map[nr][nc]!=0) {
                d = (d+1)%3;
                nr = r+dr[d];
                nc = c+dc[d];
            }
            r = nr;
            c = nc;
        }
        
        
        // 2. 배열 리턴하기
        int[] answer = new int[n*(n+1)/2];
        int index = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                answer[index++] = map[i][j];
            }
        }
        
        return answer;
    }
}