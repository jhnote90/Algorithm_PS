import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20057 {

    static int N;
    static int r;
    static int c;
    static int cnt;
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{-1, 0, 1, 0};
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        r = N / 2;
        c = N / 2;
        cnt = 0;
        int m = 1;
        int d = 0;
        while (m < N) {
            for (int i = 0; i < m; i++) {
                move(d);
            }
            d = (d + 1) % 4;
            for (int i = 0; i < m; i++) {
                move(d);
            }
            d = (d + 1) % 4;
            m++;
        }
        for (int i = 0; i < N - 1; i++) {
            move(d);
        }
        System.out.println(cnt);
    }

    private static void move(int d) {
        int sand = A[r + dr[d]][c + dc[d]];
        Queue<int[]> q = new LinkedList<>();
        if (dr[d] == 0) {
            q.offer(new int[]{r - 1, c, sand / 100});
            q.offer(new int[]{r + 1, c, sand / 100});
            q.offer(new int[]{r - 1, c + dc[d], sand * 7 / 100});
            q.offer(new int[]{r + 1, c + dc[d], sand * 7 / 100});
            q.offer(new int[]{r - 2, c + dc[d], sand * 2 / 100});
            q.offer(new int[]{r + 2, c + dc[d], sand * 2 / 100});
            q.offer(new int[]{r - 1, c + (dc[d] * 2), sand * 10 / 100});
            q.offer(new int[]{r + 1, c + (dc[d] * 2), sand * 10 / 100});
            q.offer(new int[]{r, c + (dc[d] * 3), sand * 5 / 100});
        } else {
            q.offer(new int[]{r, c - 1, sand / 100});
            q.offer(new int[]{r, c + 1, sand / 100});
            q.offer(new int[]{r + dr[d], c - 1, sand * 7 / 100});
            q.offer(new int[]{r + dr[d], c + 1, sand * 7 / 100});
            q.offer(new int[]{r + dr[d], c - 2, sand * 2 / 100});
            q.offer(new int[]{r + dr[d], c + 2, sand * 2 / 100});
            q.offer(new int[]{r + (dr[d] * 2), c - 1, sand * 10 / 100});
            q.offer(new int[]{r + (dr[d] * 2), c + 1, sand * 10 / 100});
            q.offer(new int[]{r + (dr[d] * 3), c, sand * 5 / 100});
        }
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];
            if (row < 0 || row >= N || col < 0 || col >= N) {
                cnt += pos[2];
                A[r + dr[d]][c + dc[d]] -= pos[2];
                continue;
            }
            A[row][col] += pos[2];
            A[r + dr[d]][c + dc[d]] -= pos[2];
        }
        int row = r + (dr[d] * 2);
        int col = c + (dc[d] * 2);
        if (row < 0 || row >= N || col < 0 || col >= N) {
            cnt += A[r + dr[d]][c + dc[d]];
        } else {
            A[row][col] += A[r + dr[d]][c + dc[d]];
        }
        A[r + dr[d]][c + dc[d]] = 0;
        r = r + dr[d];
        c = c + dc[d];
    }
}
