import java.io.*;

public class Main {
	static int[] sort;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		sort = new int[N];
		mergeSort(nums, 0, N-1);
		for(int num : nums) sb.append(num).append("\n");
		System.out.println(sb);
		br.close();
	}
	
	static void mergeSort(int[] nums, int left, int right) {
		int mid = (left + right) / 2;
		if(left < right) {
			
			mergeSort(nums, left, mid);
			mergeSort(nums, mid+1, right);
			
			merge(nums, left, mid, right);
		}
	}
	
	static void merge(int[] nums, int left, int mid, int right) {
		int startL = left;
		int startR = mid + 1;
		int index = left;
		
		while(startL <= mid && startR <= right) {
			if(nums[startL] < nums[startR]) sort[index++] = nums[startR++];
			else sort[index++] = nums[startL++];
		}
		
		if(startL > mid) {
			for(int i=startR; i<=right; i++) {
				sort[index++] = nums[i];
			}
		}
		else {
			for(int i=startL; i<=mid; i++) {
				sort[index++] = nums[i];
			}
		}
		
		for(int i=left; i<=right; i++) {
			nums[i] = sort[i];
		}
	}

}