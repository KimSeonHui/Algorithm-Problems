import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		// 4 ~ 10000까지 모든 소수 구하기
		boolean[] isPrime = new boolean[10001];
		for(int i=2; i<isPrime.length; i++) {
			isPrime[i] = true;
		}
		for(int i=2; i<=Math.sqrt(10000); i++) {
			for(int j=i*i; j<=10000; j+=i) {
				isPrime[j] = false;
			}
		}
		
		for(int t=0; t<T; t++) {
			int num = Integer.parseInt(br.readLine());
			
			int mid = num/2;
			while(true) {
				if(isPrime[mid] && isPrime[num-mid]) {
					sb.append(mid).append(" ").append(num-mid).append("\n");
					break;
				}
				mid--;
			}			
		}
		System.out.println(sb);
		br.close();
	}
}