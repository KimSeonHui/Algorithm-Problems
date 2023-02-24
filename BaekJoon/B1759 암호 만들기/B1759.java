package M02_4;

import java.io.*;
import java.util.*;

public class B1759 {
	static int L,C;
	static char[] pw, input; // pw : 완성된 조합 저장, input : 입력 되는 알파벳
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new char[C];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<C; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(input);
		pw = new char[L];
		comb(0, 0);
		System.out.println(sb.toString());
	}
	
	static void comb(int cnt, int start) {
		if(cnt == L) {
			//조합 완성
			if(isValidate()) {
				for(char c : pw) sb.append(c);
				sb.append("\n");
			}
			return;
		}
		for(int i=start; i<C; i++) {
			pw[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}

	static boolean isValidate() {
		int vowelCnt=0, consCnt=0;
		
		for(int i=0; i<L; i++) {
			if(pw[i]=='a' || pw[i]=='e' || pw[i]=='i'|| pw[i]=='o'|| pw[i]=='u') vowelCnt++;
			else consCnt++;
		}
		return (vowelCnt>=1 && consCnt>=2) ? true : false;
	}
}
