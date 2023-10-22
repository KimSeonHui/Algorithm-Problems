import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        map = new char[N][2*N-1];

        for(int r=0; r<N; r++) {
            for(int c=0; c<2*N-1; c++) map[r][c] = ' ';
        }
        sol(N, 0, (2*N-1)/2);

        for(char[] a : map) {
            for(char ch : a) sb.append(ch);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void sol(int n, int r, int c) {
        if(n == 3) {
            int index = 0;
            for(int i=r; i<r+n; i++) {
                for(int j=c-2; j<=c+2; j++) {
                    if(i == r+n-1) map[i][j] = '*';
                }
                if(i != r+n-1) {
                    map[i][c-index] = '*';
                    map[i][c+index] = '*';
                }
                index++;
            }
            return;
        }

        sol(n/2, r, c);
        sol(n/2, r+n/2, c-(n/2));
        sol(n/2, r+n/2, c+(n/2));
    }
}