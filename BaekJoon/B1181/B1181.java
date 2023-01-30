package backjoon;

import java.io.*;
import java.util.*;

public class B1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        
        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int r = o1.length() - o2.length();
                if(r == 0) r =  o1.compareTo(o2);
                return r;
            }
        });
        
        sb.append(arr[0]).append("\n");
        for(int i=1; i<N; i++) {
        	if(!arr[i].equals(arr[i-1])) {
        		sb.append(arr[i]).append("\n");
        	}
        }
        System.out.println(sb.toString());
    }
}