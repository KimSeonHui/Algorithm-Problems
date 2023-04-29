import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		binaryInsertionsort(nums, nums.length);
		for(int i=0; i<N; i++) {
			sb.append(nums[i]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void binaryInsertionsort(int[] arr, int size) {
		for(int i=0; i<size; i++) {
			int target = arr[i];
			
			int location = binarySearch(arr, target, 0, i);
			int j = i-1;
			
			while(j >= location) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[location] = target;
		}
	}
	
	static int binarySearch(int[] arr, int target, int start, int end) {
		int mid;
		while(start < end) {
			mid = start + ((end - start) / 2);
			
			if(target < arr[mid]) end = mid;
			else start = mid+1;
		}
		return start;
	}
}