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

        papers.put(-1, 0);
        papers.put(0, 0);
        papers.put(1, 0);

        sol(N, 0, 0);

        System.out.println(papers.get(-1));
        System.out.println(papers.get(0));
        System.out.println(papers.get(1));
    }

    static void sol(int n, int r, int c) {
        if(n == 0) return;

        if(!check(n , r, c)) {
            int size = n / 3;

            sol(size, r, c);
            sol(size, r, c + size);
            sol(size, r, c + size * 2);

            sol(size, r + size, c);
            sol(size, r + size, c + size);
            sol(size, r + size, c + size * 2);

            sol(size, r + size * 2, c);
            sol(size, r + size * 2, c + size);
            sol(size, r + size * 2, c + size * 2);
        }
        else {
            int ele = map[r][c];
            papers.put(ele, papers.get(ele) + 1);
        }
    }

    static boolean check(int n, int r, int c) {
        int start = map[r][c];
        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                if(start != map[i][j]) return false;
            }
        }
        return true;
    }
}