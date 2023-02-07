import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16197 {

    static int n;
    static int m;
    static int cnt;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        Coin[] coins = new Coin[2];
        int c = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                switch (str.charAt(j)) {
                    case 'o':
                        board[i][j] = 0;
                        coins[c] = new Coin(i, j);
                        c++;
                        break;
                    case '.':
                        board[i][j] = 0;
                        break;
                    case '#':
                        board[i][j] = 1;
                }
            }
        }
        cnt = 0;
        bfs(coins);
        System.out.println(cnt);
    }

    private static void bfs(Coin[] coins) {
        Queue<Coin[]> queue = new LinkedList<>();
        queue.offer(coins);
        Coin[] e;
        int qSize;
        while (!queue.isEmpty()) {
            cnt++;
            if (cnt > 10) {
                cnt = -1;
                return;
            }
            qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                coins = queue.poll();
                for (int j = 0; j < 4; j++) {
                    e = new Coin[2];
                    int fall = 0;
                    for (int k = 0; k < 2; k++) {
                        int r = coins[k].row + dr[j];
                        int c = coins[k].col + dc[j];
                        if (r < 0 || r >= n || c < 0 || c >= m) {
                            fall++;
                            continue;
                        }
                        if (board[r][c] == 0) {
                            e[k] = new Coin(r, c);
                        } else {
                            e[k] = new Coin(coins[k].row, coins[k].col);
                        }
                    }
                    if (fall == 0) {
                        queue.offer(e);
                    } else if (fall == 1) {
                        return;
                    }
                }
            }

        }

    }

    static class Coin {

        int row;
        int col;

        public Coin(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
