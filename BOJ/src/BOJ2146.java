import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146 {
	static int n, island, bridgeLen;
	static int[][] map, dist;
	static boolean[][] visited;
	static Queue<Point> queue;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	
	static class Point {
		int row;
		int col;
		
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dist = new int[n][n];
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n][n];
		island = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					island++;
					dfs(i, j);
				}
			}
		}
		queue = new LinkedList<>();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (map[i][j] == 0)
					dist[i][j] = -1;
				else
					queue.add(new Point(i, j));
			}
		}
		bfs();
		bridgeLen = n * n;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<4; k++) {
					int r = i + dr[k];
					int c = j + dc[k];
					if (r < 0 || r >= n)
						continue;
					if (c < 0 || c >= n)
						continue;
					if (map[i][j] != map[r][c]) {
						int temp = dist[i][j] + dist[r][c];
						if (bridgeLen > temp)
							bridgeLen = temp;
					}
				}
			}
		}
		System.out.println(bridgeLen);
	}
	
	public static void dfs(int row, int col) {
		if (row < 0 || row >= n)
			return;
		if (col < 0 || col >= n)
			return;
		if (map[row][col] == 0 || visited[row][col])
			return;
		map[row][col] = island;
		visited[row][col] = true;
		for (int i=0; i<4; i++)
			dfs(row+dr[i], col+dc[i]);
	}
	
	public static void bfs() {
		Point point;
		int r, c;
		while (!queue.isEmpty()) {
			point = queue.remove();
			for (int i=0; i<4; i++) {
				r = point.row + dr[i];
				c = point.col + dc[i];
				if (r < 0 || r >= n)
					continue;
				if (c < 0 || c >= n)
					continue;
				if (dist[r][c] == -1) {
					dist[r][c] = dist[point.row][point.col] + 1;
					map[r][c] = map[point.row][point.col];
					queue.add(new Point(r, c));
				}
			}
		}
	}

}
