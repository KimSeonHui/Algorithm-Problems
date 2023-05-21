import java.io.*;
import java.util.*;

class Point {
    int r;
    int c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int[][] map;
    static int N;
    static int M;
    static Point[] res;
    static List<Point> chicken;
    static int minChickenDis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        chicken = new ArrayList<>();
        res = new Point[M];
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j=0; j<N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 2) chicken.add(new Point(i,j));
        	}
        }
        minChickenDis = Integer.MAX_VALUE;
        comb(0,0);
        System.out.println(minChickenDis);
    }
    
    static void comb(int cnt, int start) {
    	if(cnt == M) {
    		// 도시 치킨 거리 최솟값 구하기
    		minChickenDis = cal_cityChickenDis();
    		return;
    	}
    	for(int i=start; i<chicken.size(); i++) {
    		res[cnt] = chicken.get(i);
    		comb(cnt+1, i+1);
    	}
    }

    static int cal_cityChickenDis() {
    	int cityChickenDis = 0;
    	for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					int minHouseChickenDis = Integer.MAX_VALUE;
					for(int k=0; k<M; k++) {
			    		int r = res[k].r;
			    		int c = res[k].c;
			    		
			    		int houseChickenDis = Math.abs(r-i) + Math.abs(c-j);
			    		minHouseChickenDis = Math.min(minHouseChickenDis, houseChickenDis);
			    	}
					cityChickenDis += minHouseChickenDis;
				}
			}
		}
     	return minChickenDis = Math.min(minChickenDis, cityChickenDis);
    }
}
