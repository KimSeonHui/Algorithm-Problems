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
		if(left < right) {
			int mid = (left+right)/2;
			
			mergeSort(nums, left, mid);
			mergeSort(nums, mid+1, right);
			
			merge(nums, left, mid, right);
		}
	}
	
	static void merge(int[] nums, int left, int mid, int right) {
		int startL = left; // 왼쪽 배열
		int startR = mid+1; // 오른쪽 배열
		int startS = left; // merge할 배열 시작 index
		
		// 왼쪽 배열, 오른쪽 배열 중 하나가 모두 sort에 옮겨질 때까지 반복
		while(startL <=mid && startR <=right) {
			if(nums[startL] <= nums[startR]) sort[startS++] = nums[startL++];
			else sort[startS++] = nums[startR++];
		}
		
		
		if(mid < startL) { // 왼쪽 배열을 모두 sort 배열에 넣었으면
			for(int i=startR; i<=right; i++) { // 남은 오른쪽 배열을 sort배열에 넣기
				sort[startS++] = nums[i];
			}
		}
		else { // 오른쪽 배열을 모두 sort 배열에 넣었으면
			for(int i=startL; i<=mid; i++) { // 남은 왼쪽 배열을 sort배열에 넣기
				sort[startS++] = nums[i];
			}
		}
		
		// merge한 sort배열을 원본 nums에 옮기기 
		for(int i=left; i<=right; i++) {
			nums[i] = sort[i];
		}
	}
}