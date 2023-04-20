package M04_4;

import java.io.*;
import java.util.*;

public class B10845 {
	static class Queue {
		private int front, back = 0;
		private int size = 0;
		private int[] arrf, arrb;
		
		public Queue(int n) {
			arrf = new int[n];
			arrb = new int[n];
		}
		
		public void push(int num) {
			arrb[back++] = num;
			size++;
		}
		
		public int pop() {
			int ele = -1;
			if(back-1 >= 0) {
				for(int i=back-1; i>=0; i--) {
					arrf[front++] = arrb[i];
					arrb[i]=0;
				}
				
				ele = arrf[front-1];
				
				back=0;
				for(int i=front-2; i>=0; i--) {
					arrb[back++] = arrf[i];
					arrf[i]=0;
				}
				front=0;
				size--;
			}
			return ele;
		}
		
		public int size() {
			return size;
		}
		
		public int empty() {
			return size==0? 1 : 0;
		}
		
		public int front() {
			return size !=0 ? arrb[0] : -1;
		}
		
		public int back() {
			return size !=0 ? arrb[back-1] : -1;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		Queue queue = new Queue(n);
		int i = 0;
		while(i < n) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String oper = st.nextToken();
			if(oper.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				queue.push(num);
			}
			else if(oper.equals("pop")) sb.append(queue.pop()).append("\n");
			else if(oper.equals("size")) sb.append(queue.size()).append("\n");
			else if(oper.equals("empty")) sb.append(queue.empty()).append("\n");
			else if(oper.equals("front")) sb.append(queue.front()).append("\n");
			else if(oper.equals("back")) sb.append(queue.back()).append("\n");
			
			i++;
		}
		System.out.println(sb);
		br.close();
	}
}