import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17144 {

    static int R;
    static int C;
    static int T;
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        A = new int[R][C];
        int[] top = new int[2];
        int[] bot = new int[2];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == -1) {
                    if (top[0] == 0) {
                        top[0] = i;
                        top[1] = j;
                    } else {
                        bot[0] = i;
                        bot[1] = j;
                    }
                }
            }
        }
        for (int i = 0; i < T; i++) {
            diffusion();
            cleanTop(top[0], top[1]);
            cleanBot(bot[0], bot[1]);
        }
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) {
                    sum += A[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    private static void cleanBot(int row, int col) {
        for (int i = row + 1; i < R - 1; i++) {
            A[i][col] = A[i + 1][col];
        }
        for (int i = 0; i < C - 1; i++) {
            A[R - 1][i] = A[R - 1][i + 1];
        }
        for (int i = R - 1; i > row; i--) {
            A[i][C - 1] = A[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            A[row][i] = A[row][i - 1];
        }
        A[row][1] = 0;
    }

    private static void cleanTop(int row, int col) {
        for (int i = row - 1; i > 0; i--) {
            A[i][col] = A[i - 1][col];
        }
        for (int i = 0; i < C - 1; i++) {
            A[0][i] = A[0][i + 1];
        }
        for (int i = 0; i < row; i++) {
            A[i][C - 1] = A[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            A[row][i] = A[row][i - 1];
        }
        A[row][1] = 0;
    }

    private static void diffusion() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] > 0) {
                    q.offer(new int[]{i, j, A[i][j]});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int row = poll[0];
            int col = poll[1];
            int num = poll[2] / 5;
            for (int i = 0; i < 4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r < 0 || r >= R || c < 0 || c >= C) {
                    continue;
                }
                if (A[r][c] != -1) {
                    A[r][c] += num;
                    A[row][col] -= num;
                }
            }
        }
    }
}
