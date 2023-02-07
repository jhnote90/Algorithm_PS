import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928 {

    static int n;
    static int m;
    static boolean[] visited;
    static int[][] ladders;
    static int[][] snakes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ladders = new int[n][2];
        snakes = new int[m][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ladders[i][0] = Integer.parseInt(st.nextToken());
            ladders[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            snakes[i][0] = Integer.parseInt(st.nextToken());
            snakes[i][1] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[101];
        int num = bfs();
        System.out.println(num);
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                for (int j = 0; j < n; j++) {
                    if (num == ladders[j][0]) {
                        num = ladders[j][1];
                        visited[num] = true;
                        break;
                    }
                }
                for (int j = 0; j < m; j++) {
                    if (num == snakes[j][0]) {
                        num = snakes[j][1];
                        visited[num] = true;
                        break;
                    }
                }
                if (num == 100) {
                    return cnt;
                }
                for (int j = 1; j <= 6; j++) {
                    if ((num + j) <= 100 && !visited[num + j]) {
                        visited[num + j] = true;
                        q.add(num + j);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
