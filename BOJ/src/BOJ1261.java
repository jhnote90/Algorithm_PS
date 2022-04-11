import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1261 {
	static int N, M;
	static int min;
	static int[][] maze;
	static int[][] visited;
	static int[] dr = new int[] {1, 0, -1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new int[N][M];
		String str;
		for (int i=0; i<N; i++) {
			str = br.readLine();
			for (int j=0; j<M; j++) {
				maze[i][j] = str.charAt(j) - '0';
				visited[i][j] = -1;
			}
		}
		min = N * M;
		dfs(0, 0, 0);
		System.out.println(min);
	}
	
	public static void dfs(int r, int c, int broke) {
		if (r == N-1 && c == M-1) {
			if (broke < min)
				min = broke;
			return;
		}
		visited[r][c] = broke;
		int row, col;
		for (int i=0; i<4; i++) {
			row = r + dr[i];
			col = c + dc[i];
			if (promising(row, col, broke)) {
				if (maze[row][col] == 1)
					dfs(row, col, broke+1);
				else
					dfs(row, col, broke);
			}
		}
	}
	
	public static boolean promising(int r, int c, int broke) {
		if (r<0 || r>=N || c<0 || c>=M)
			return false;
		if (maze[r][c] == 1)
			broke++;
		if (broke >= min)
			return false;
		if (visited[r][c] != -1 && broke >= visited[r][c])
			return false;
		return true;
	}

}
