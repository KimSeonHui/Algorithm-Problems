import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static StringBuilder sb = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int r=0; r<N; r++) {
            String str = br.readLine();
            for(int c=0; c<N; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        sol(N, 0, 0);
        System.out.println(sb);
    }

    public static void sol(int n, int r, int c) {
        if(n == 0) {
            return;
        }

        if(!check(n , r, c)) {
            int half = n / 2;

            sb.append("(");
            sol(half, r, c);
            sol(half, r, c + half);
            sol(half, r + half, c);
            sol(half, r + half , c + half);
            sb.append(")");
        }
        else sb.append(map[r][c]);

    }

    public static boolean check(int n, int r, int c) {
        boolean checked = true;
        int start = map[r][c];

        for(int i=r; i<r+n; i++) {
            for(int j=c; j<c+n; j++) {
                if(map[i][j] != start) return false;
            }
        }
        return checked;
    }
}