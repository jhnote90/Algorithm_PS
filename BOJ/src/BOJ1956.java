import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1956 {

    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] floyd = new int[V + 1][V + 1];
        for (int i = 0; i < V + 1; i++) {
            for (int j = 0; j < V + 1; j++) {
                floyd[i][j] = INF;
            }
        }
        int a, b, c;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            floyd[a][b] = c;
        }
        for (int k = 1; k < V + 1; k++) {
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }
        int min = INF;
        for (int i = 1; i < V + 1; i++) {
            min = Math.min(min, floyd[i][i]);
        }
        if (min == INF) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

}
