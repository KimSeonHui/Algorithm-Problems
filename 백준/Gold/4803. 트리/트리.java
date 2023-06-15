import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    static Set<Integer> parent, cycleChild;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int t = 1;
        while(true) {
            parent = new HashSet<>();
            cycleChild = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            makeSet(N);
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(!union(a, b)) {
                    cycleChild.add(a);
                    cycleChild.add(b);
                }
            }

            // union이 끝난 뒤 부모 등록
            for(int i=1; i<=N; i++) {
                parent.add(find(p[i]));
            }

            // cycle 있는 정점의 부모 찾기
            Iterator it = cycleChild.iterator();
            while(it.hasNext()) {
                int cycleParent = find((int) it.next());
                if(parent.contains(cycleParent)) parent.remove(cycleParent); // 사이클이 있는 부모 제외
            }

            int ans = parent.size();
            sb.append("Case " + t + ": ");
            if(ans == 0) sb.append("No trees.");
            else if(ans == 1) sb.append("There is one tree.");
            else sb.append("A forest of "+ ans +" trees.");
            sb.append("\n");
            t++;
        }
        System.out.println(sb);
        br.close();
    }

    public static void makeSet(int N) {
        p = new int[N+1];
        for(int i=1; i<=N; i++)  p[i] = i;
    }

    public static int find(int a) {
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return false;

        if(rootA <= rootB) p[rootB] = rootA;
        else p[rootA] = rootB;
        return true;
    }
}