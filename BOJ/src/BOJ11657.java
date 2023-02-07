import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11657 {
    static int n;
    static int m;
    static final long INF = Long.MAX_VALUE;
    static long[] shortest;
    static List<int[]> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        shortest = new long[n + 1];
        for (int i = 0; i < n + 1; i++) {
            shortest[i] = INF;
        }
        edges = new ArrayList<>();
        int a, b, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, c});
        }
        if (!bellmanFord(1)) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < n + 1; i++) {
                if (shortest[i] == INF) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(shortest[i]).append("\n");
                }
            }
            System.out.print(sb);
        }
    }

    private static boolean bellmanFord(int s) {
        shortest[s] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                if (shortest[edge[0]] == INF)
                    continue;
                shortest[edge[1]] = Math.min(shortest[edge[1]], shortest[edge[0]] + edge[2]);
            }
        }
        for (int[] edge : edges) {
            if (shortest[edge[0]] == INF)
                continue;
            if ((shortest[edge[0]] + edge[2]) < shortest[edge[1]]) {
                return false;
            }
        }
        return true;
    }
}
