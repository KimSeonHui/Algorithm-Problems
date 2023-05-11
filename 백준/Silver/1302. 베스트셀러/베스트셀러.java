import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		String ans = "";
		
		String[] books = new String[N];
		for(int i=0; i<N; i++) books[i] = br.readLine();
		Arrays.sort(books);
		
		for(int i=0; i<N; i++) {
			String book = books[i];
			Integer num = map.get(book);
			if(num != null) map.put(book, num+1);
			else map.put(book, 1);
			
			if(max < map.get(book)) {
				max = map.get(book);
				ans = book;
			}
		}
		System.out.println(ans);
		br.close();
	}

}