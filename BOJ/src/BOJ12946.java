import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12946 {

    static int n;
    static int[] dr = new int[]{-1, -1, 0, 1, 1, 0};
    static int[] dc = new int[]{0, 1, 1, 0, -1, -1};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '-') {
                    board[i][j] = -1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    dfs(i, j, 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        System.out.println(max);
    }

    private static void dfs(int row, int col, int num) {
        board[row][col] = -1;
        for (int i = 0; i < 6; i++) {
            int r = row + dr[i];
            int c = col + dc[i];
            if (r < 0 || r >= n || c < 0 || c >= n) {
                continue;
            }
            if (board[r][c] == 0) {
                if (num == 1) {
                    dfs(r, c, 2);
                } else {
                    dfs(r, c, 1);
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            int r = row + dr[i];
            int c = col + dc[i];
            if (r < 0 || r >= n || c < 0 || c >= n) {
                continue;
            }
            if (board[r][c] == num) {
                board[row][col] = 3;
                return;
            }
        }
        board[row][col] = num;
    }

}
