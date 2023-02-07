import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2206 {

    static int n;
    static int m;
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};
    static int[][] map;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
                visited[i][j][0] = n * m + 1;
                visited[i][j][1] = n * m + 1;
            }
        }
        bfs();
        int cnt = Math.min(visited[n - 1][m - 1][0], visited[n - 1][m - 1][1]);
        if (cnt < (n * m + 1)) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs() {
        int row, col, state;
        Queue<List<Integer>> q = new LinkedList<>();
        row = 0;
        col = 0;
        state = 0;
        visited[row][col][state] = 1;
        List<Integer> list = new ArrayList<>();
        list.add(row);
        list.add(col);
        list.add(state);
        q.offer(list);
        while (!q.isEmpty()) {
            List<Integer> pollList = q.poll();
            row = pollList.get(0);
            col = pollList.get(1);
            state = pollList.get(2);
            int num = visited[row][col][state] + 1;
            for (int i = 0; i < 4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r < 0 || r >= n || c < 0 || c >= m) {
                    continue;
                }
                if (map[r][c] == 0) {
                    if (state == 0) {
                        if (num < visited[r][c][state]) {
                            visited[r][c][state] = num;
                            list = new ArrayList<>();
                            list.add(r);
                            list.add(c);
                            list.add(state);
                            q.offer(list);
                        }
                    } else {
                        if (num < visited[r][c][state] &&
                                num < visited[r][c][0]) {
                            visited[r][c][state] = num;
                            list = new ArrayList<>();
                            list.add(r);
                            list.add(c);
                            list.add(state);
                            q.offer(list);
                        }
                    }
                } else if (state == 0) {
                    if (num < visited[r][c][1]) {
                        visited[r][c][1] = num;
                        list = new ArrayList<>();
                        list.add(r);
                        list.add(c);
                        list.add(1);
                        q.offer(list);
                    }
                }
            }
        }
    }

//    private static void dfs(int r, int c, int num) {
//        visited[r][c] = num;
//        if (r == n - 1 && c == m - 1) {
//            return;
//        }
//        for (int i = 0; i < 4; i++) {
//            int row = r + dr[i];
//            int col = c + dc[i];
//            if (row < 0 || row >= n || col < 0 || col >= m) {
//                continue;
//            }
//            if ((num + 1) >= visited[row][col]) {
//                continue;
//            }
//            if (map[row][col] == 0) {
//                dfs(row, col, num + 1);
//            } else {
//                if (!breaked) {
//                    breaked = true;
//                    dfs(row, col, num + 1);
//                    breaked = false;
//                }
//            }
//        }
//    }
}
