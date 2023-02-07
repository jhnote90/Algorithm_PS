import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {

    static int V;
    static int E;
    static final int INF = Integer.MAX_VALUE;
    static int[] shortest;
    static List<List<int[]>> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine());
        int u, v, w;
        lists = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            lists.get(u).add(new int[]{v, w});
        }
        shortest = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            shortest[i] = INF;
        }
        dijkstra(s);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < V + 1; i++) {
            if (shortest[i] == INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(shortest[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static void dijkstra(int s) {
        shortest[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        pq.offer(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            if (shortest[poll[0]] < poll[1]) {
                continue;
            }
            List<int[]> list = lists.get(poll[0]);
            for (int[] o : list) {
                if ((poll[1] + o[1]) < shortest[o[0]]) {
                    shortest[o[0]] = poll[1] + o[1];
                    pq.offer(new int[]{o[0], shortest[o[0]]});
                }
            }
        }
    }


}
