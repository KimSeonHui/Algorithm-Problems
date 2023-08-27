import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] students = new int[7][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            students[grade][sex]++;
        }

        int rooms = 0;
        for(int i=1; i<students.length; i++) {
            for(int j=0; j<students[0].length; j++) {
                rooms += students[i][j] / K;
                if(students[i][j] % K != 0) rooms += 1;
            }
        }
        System.out.println(rooms);
        br.close();
    }
}