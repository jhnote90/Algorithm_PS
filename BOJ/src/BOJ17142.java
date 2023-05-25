import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17142 {

    static int N;
    static int M;
    static int t;
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};
    static int[] sol;
    static int[][] lab;
    static List<Integer> virus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        t = -1;
        sol = new int[M];
        lab = new int[N][N];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virus.add(i * N + j);
                }
            }
        }
        comb(0, -1);
        System.out.println(t);
    }

    private static void comb(int depth, int s) {
        if (depth == M) {
            bfs();
            return;
        }
        for (int i = s + 1; i <= virus.size() - (M - depth); i++) {
            sol[depth] = virus.get(i);
            comb(depth + 1, i);
        }
    }

    private static void bfs() {
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = lab[i][j];
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int num : sol) {
            int row = num / N;
            int col = num % N;
            map[row][col] = -1;
            q.offer(new int[]{row, col});
        }
        int time = 0;
        while (!q.isEmpty()) {
            if (t != -1 && time >= t) {
                return;
            }
            boolean allSpread = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        allSpread = false;
                        break;
                    }
                }
                if (!allSpread) {
                    break;
                }
            }
            if (allSpread) {
                t = time;
                return;
            }
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] pos = q.poll();
                for (int j = 0; j < 4; j++) {
                    int r = pos[0] + dr[j];
                    int c = pos[1] + dc[j];
                    if (r < 0 || r >= N || c < 0 || c >= N) {
                        continue;
                    }
                    if (map[r][c] == 0 || map[r][c] == 2) {
                        map[r][c] = -1;
                        q.offer(new int[]{r, c});
                    }
                }
            }
            time++;
        }
    }
}
