package M04_5;

import java.io.*;

public class B15688 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N]; 
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		quickSort(nums, 0, N-1);
		for(int num : nums) sb.append(num).append("\n");
		System.out.println(sb);
		br.close();
	}
	
	static void quickSort(int[] a, int left, int right) {
		int start = left;
		int end = right;
		int pivot = a[(start+end)/2];
		
		while(start <= end) {
			while(a[start] < pivot) start++;
			while(a[end] > pivot) end--;
			
			if(start <= end) {
				swap(a, start, end);
				start++;
				end--;
			}
		}
		
		if(left < end) quickSort(a, left, end);
		if(start < right) quickSort(a, start, right);
	}
	
	static void swap(int[] a, int s, int e) {
		int temp = a[s];
		a[s] = a[e];
		a[e] = temp;
	}

}
