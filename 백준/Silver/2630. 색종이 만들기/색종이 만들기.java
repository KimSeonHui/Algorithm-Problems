import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static Map<Integer, Integer> papers = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st = null;
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int c=0; c<N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        papers.put(0 , 0); // 하양
        papers.put(1 , 0); // 파랑

        sol(N, 0, 0);
        System.out.println(papers.get(0));
        System.out.println(papers.get(1));
    }

    static void sol(int n, int r, int c) {
        if(n == 0) return;

        if(!check(n ,r ,c)) {
            int half = n / 2;

            sol(half, r, c);
            sol(half, r, c + half);
            sol(half, r + half, c);
            sol(half, r + half, c + half);
        }
        else {
            int ele = map[r][c];
            papers.put(ele, papers.get(ele) + 1);
        }
    }

    static boolean check(int n, int r, int c) {
        int ele = map[r][c];
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                if(ele != map[i][j]) return false;
            }
        }
        return true;
    }
}