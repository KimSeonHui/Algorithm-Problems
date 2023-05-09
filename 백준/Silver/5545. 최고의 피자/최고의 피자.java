import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] topings = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] prices = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		int calDo = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			topings[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(topings, (o1, o2) -> -Integer.compare(o1, o2));
		
		int topingCnt=0;
		int totalCal = calDo;
		int perCal = calDo / prices[0];
		for(int i=0; i<N; i++) {
			totalCal += topings[i];
			topingCnt++;
			
			int newPerCal = totalCal / (prices[0] + prices[1] * topingCnt);
			if(perCal <= newPerCal) perCal = newPerCal;
			else break;
		}
		System.out.println(perCal);

		br.close();
	}
}
