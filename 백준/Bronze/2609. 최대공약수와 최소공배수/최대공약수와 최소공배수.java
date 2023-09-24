import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int gcdNum = 0;
        if(a > b) gcdNum = gcd(a, b);
        else gcdNum = gcd(b, a);
        
        System.out.println(gcdNum);
        System.out.println(a * b / gcdNum);

    }
    
    public static int gcd(int a, int b) {
        int rest = a % b;
        if(rest == 0) return b;
        else return gcd(b, rest);
    }
}