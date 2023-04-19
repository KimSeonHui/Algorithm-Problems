package M04_4;

import java.io.*;
import java.util.*;

public class B10828 {
	static class Stack {
		private int[] s;
		private int index=0;
		public int size;
		
		public Stack(int n) {
			s = new int[n];
		}
		
		public void push(int num) {
			s[index++] = num;
			size++;
		}
		
		public int pop() {
			int ele = -1;
			if(index > 0) {
				ele = s[index-1];
				s[index-1] = 0;
				index--;
				size--;
			}
			return ele;
		}
		
		public int size() {
			return size;
		}
		
		public int empty() {
			return size==0 ? 1 : 0;
		}
		
		public int top() {
			if(index > 0) return s[index-1];
			else return -1;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack stack = new Stack(N);
		
		int i=0;
		while(i < N) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String operation = st.nextToken();
			if(operation.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}
			else if(operation.equals("top")) sb.append(stack.top()).append("\n");
			else if(operation.equals("size")) sb.append(stack.size).append("\n");
			else if(operation.equals("empty")) sb.append(stack.empty()).append("\n");
			else if(operation.equals("pop")) sb.append(stack.pop()).append("\n");
			i++;
		}
		System.out.println(sb);
		br.close();
	}
}