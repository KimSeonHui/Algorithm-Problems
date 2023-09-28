import java.io.*;
import java.util.*;

public class Main {
    static int N, R, C = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sol(N, R, C, 0);
    }

    public static void sol(int n, int r, int c, int index) {
        if(n == 0) {
            System.out.println(index);
            return;
        }

        int size = (int)Math.pow(2, n-1);
        int boxR = r / size;
        int boxC = c / size;

        if(boxR == 0 && boxC == 0) sol(n-1, r, c, index); // 좌상
        if(boxR == 0 && boxC == 1) sol(n-1, r, c - size, index + size * size); // 우상
        if(boxR == 1 && boxC == 0) sol(n-1, r - size, c, index + size * size * 2); // 좌하
        if(boxR == 1 && boxC == 1) sol(n-1, r - size, c - size, index + size * size * 3); // 우하
    }
}