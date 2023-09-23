import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int num = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<=n; i++) {
            int input = Integer.parseInt(br.readLine());

            while(num <= input) {
                sb.append("+" + "\n");
                stack.push(num++);
            }
            if(stack.peek() == input) {
                sb.append("-" + "\n");
                stack.pop();
            }
            else if(input < stack.peek()) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}