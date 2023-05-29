import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17779 {

    static int N;
    static int min;
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};
    static int[][] A;
    static int[][] P;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        A = new int[N+1][N+1];
        visited = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        P = new int[N + 1][N + 1];
        for (int d1 = 1; d1 < N - 1; d1++) {
            for (int d2 = 1; d1 + d2 < N; d2++) {
                for (int x = 1; x <= N - d1 - d2; x++) {
                    for (int y = 1 + d1; y <= N - d2; y++) {
                        for (int i = 0; i <= d1; i++) {
                            P[x+i][y-i] = 5;
                            P[x+d2+i][y+d2-i] = 5;
                        }
                        for (int i = 0; i <= d2; i++) {
                            P[x+i][y+i] = 5;
                            P[x+d1+i][y-d1+i] = 5;
                        }
                        for (int i = x + 1; i < x + d1 + d2; i++) {
                            List<Integer> list = new ArrayList<>();
                            for (int j = 1; j <= N; j++) {
                                if (P[i][j] == 5) {
                                    list.add(j);
                                }
                            }
                            for (int j = list.get(0) + 1; j < list.get(1); j++) {
                                P[i][j] = 5;
                            }
                        }
                        List<Integer> list = new ArrayList<>();
                        for (int i = 1; i < x + d1; i++) {
                            for (int j = 1; j <= y; j++) {
                                if (P[i][j] != 5) {
                                    P[i][j] = 1;
                                }
                            }
                        }
                        for (int i = 1; i <= x + d2; i++) {
                            for (int j = y + 1; j <= N; j++) {
                                if (P[i][j] != 5) {
                                    P[i][j] = 2;
                                }
                            }
                        }
                        for (int i = x + d1; i <= N; i++) {
                            for (int j = 1; j < y - d1 + d2; j++) {
                                if (P[i][j] != 5) {
                                    P[i][j] = 3;
                                }
                            }
                        }
                        for (int i = x + d2 + 1; i <= N; i++) {
                            for (int j = y - d1 + d2; j <= N; j++) {
                                if (P[i][j] != 5) {
                                    P[i][j] = 4;
                                }
                            }
                        }
                        list.add(bfs(1, 1, 1, 4));
                        list.add(bfs(1, N, 2, 3));
                        list.add(bfs(N, 1, 3, 2));
                        list.add(bfs(N, N, 4, 1));
                        list.add(bfs(x, y, 5, 5));
                        min = Math.min(min, Collections.max(list) - Collections.min(list));
                        for (int i = 1; i <= N; i++) {
                            for (int j = 1; j <= N; j++) {
                                P[i][j] = 0;
                                visited[i][j] = false;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }

    private static int bfs(int row, int col, int n1, int n2) {
        Queue<int[]> q = new LinkedList<>();
        visited[row][col] = true;
        q.offer(new int[]{row, col});
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            cnt += A[pos[0]][pos[1]];
            for (int i = 0; i < 4; i++) {
                int r = pos[0] + dr[i];
                int c = pos[1] + dc[i];
                if (r < 1 || r > N || c < 1 || c > N || visited[r][c]) {
                    continue;
                }
                if (P[r][c] == n1 || P[r][c] == n2) {
                    visited[r][c] = true;
                    q.offer(new int[]{r, c});
                }
            }
        }
        return cnt;
    }
}
