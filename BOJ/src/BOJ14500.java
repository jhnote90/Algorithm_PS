import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {
	static int n;
	static int m;
	static int max;
	static int[] dr = new int[] {1, 0, -1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	static int[][] paper;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paper = new int[n][m];
		visited = new int[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
					tetromino(i, j, 1, 0);
					tTetro(i, j);
			}
		}
		System.out.println(max);
	}
	
	public static void tetromino(int r, int c, int depth, int sum) {
		if (r<0 || r>=n || c<0 || c>=m || visited[r][c] == 1)
			return;
		visited[r][c] = 1;
		sum += paper[r][c];
		if (depth == 4) {
			if (sum > max)
				max = sum;
		}
		else {
			for (int i=0; i<4; i++) {
				tetromino(r+dr[i], c+dc[i], depth+1, sum);
			}
		}
		visited[r][c] = 0;
	}
	
	public static void tTetro(int r, int c) {
		int depth = 1;
		int sum = paper[r][c];
		int row, col;
		for (int i=0; i<4; i++) {
			row = r + dr[i];
			col = c + dc[i];
			if (row<0 || row>=n || col<0 || col>=m)
				continue;
			depth++;
			sum += paper[row][col];
		}
		if (depth == 5) {
			for (int i=0; i<4; i++) {
				row = r + dr[i];
				col = c + dc[i];
				max = Math.max(max, sum-paper[row][col]);
			}
		}
		else if (depth == 4)
			max = Math.max(max, sum);
	}

}
