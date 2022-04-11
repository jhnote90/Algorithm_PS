import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
	static int R;
	static int C;
	static int max;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	static int[][] board;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		visited = new int[R][C];
		String str;
		for (int i=0; i<R; i++) {
			str = br.readLine();
			for (int j=0; j<C; j++) {
				board[i][j] = str.charAt(j) - 'A';
			}
		}
		max = 0;
		dfs(0, 0, 1, 1<<board[0][0]);
		System.out.println(max);
	}
	
	public static void dfs(int row, int col, int depth, int bit) {
		if (visited[row][col] == bit)
			return;
		visited[row][col] = bit;
		if (max < depth)
			max = depth;
		for (int i=0; i<4; i++) {
			if (promising(row+dr[i], col+dc[i], bit)) {
				dfs(row+dr[i], col+dc[i], depth+1, bit|(1<<board[row+dr[i]][col+dc[i]]));
			}
		}
	}
	
	public static boolean promising(int row, int col, int bit) {
		if ((row < 0) || (row >= R))
			return false;
		if ((col < 0) || (col >= C))
			return false;
		if ((bit & (1<<board[row][col])) != 0)
			return false;
		return true;
	}

}
