import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 {

    static int N;
    static int fish;
    static int t;
    static int cnt;
    static int[] bs;
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};
    static int[][] space;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fish = 0;
        t = 0;
        cnt = 0;
        bs = new int[3];
        space = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    bs[0] = i;
                    bs[1] = j;
                    bs[2] = 2;
                } else if (space[i][j] >= 1 && space[i][j] <= 6) {
                    fish++;
                }
            }
        }
        while (fish > 0) {
            if (!bfs()) {
                break;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited[i][j] = false;
                }
            }
        }
        System.out.println(t);
    }

    private static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited[bs[0]][bs[1]] = true;
        q.offer(new int[]{bs[0], bs[1]});
        int dist = 0;
        int row = N;
        int col = N;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] pos = q.poll();
                for (int j = 0; j < 4; j++) {
                    int r = pos[0] + dr[j];
                    int c = pos[1] + dc[j];
                    if (r < 0 || r >= N || c < 0 || c >= N || visited[r][c]) {
                        continue;
                    }
                    if (space[r][c] == 0 || space[r][c] == bs[2]) {
                        visited[r][c] = true;
                        q.offer(new int[]{r, c});
                    } else if (space[r][c] > 0 && space[r][c] < bs[2]) {
                        visited[r][c] = true;
                        if (r < row) {
                            row = r;
                            col = c;
                        } else if (r == row && c < col) {
                            row = r;
                            col = c;
                        }
                    }
                }
            }
            dist++;
            if (row < N && col < N) {
                space[bs[0]][bs[1]] = 0;
                space[row][col] = 9;
                bs[0] = row;
                bs[1] = col;
                fish--;
                cnt++;
                if (cnt == bs[2]) {
                    bs[2]++;
                    cnt = 0;
                }
                t += dist;
                return true;
            }
        }
        return false;
    }
}
