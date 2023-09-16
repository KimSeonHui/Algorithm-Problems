import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int cnt = 0;

        stack.push(64);
        sum += 64;

        while(sum > X) {
            int min = stack.pop();
            sum -= min;

            int half = min / 2;

            if(sum + half >= X) {
                stack.push(half);
                sum += half;
            }
            else {
                stack.push(half);
                stack.push(half);
                sum += half * 2;
            }
        }

        System.out.println(stack.size());
    }
}