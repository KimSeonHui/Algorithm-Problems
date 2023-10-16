import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        sb = new StringBuilder();

        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                sol(N, r, c);
            }
        }
        for(char[] a : map) {
            for(char ch : a) sb.append(ch);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void sol(int size, int r, int c) {
            if((r / size) % 3 == 1 && (c / size) % 3 == 1) map[r][c] = ' ';
            else {
                if(size == 1) map[r][c] = '*';
                else sol(size / 3, r, c);
            }
    }
}