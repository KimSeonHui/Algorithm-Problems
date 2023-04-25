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
			
			int min = Integer.MAX_VALUE; // 골드바흐 파티션을 이루는 두 소수 차이의 최솟값
			int prime = 0;
			for(int i=2; i<=num; i++) {
				if(isPrime[i]) { // i가 소수이면
					
					if(isPrime[num-i]) { // num-i 가 소수인지 확인
						// 현재 골드바흐 파티션의 두 소수 차이가 최소이면
						if(Math.abs(i-(num-i)) < min) { 
							min = Math.abs(i-(num-i));
							prime = i;
						}
					}
				}
			}
			sb.append(prime).append(" ").append(num-prime).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}