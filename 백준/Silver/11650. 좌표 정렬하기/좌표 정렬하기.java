import java.io.*;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int x, y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo (Point o) {
            int r = Integer.compare(x, o.x);
            if(r == 0) r = Integer.compare(y, o.y);
            return r;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];

        StringTokenizer st = null;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(points);
        for(Point p : points) System.out.println(p.x + " " + p.y);
    }
}