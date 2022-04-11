import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
	static int n;
	static int m;
	static int direction;
	static int cleaning;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r, c;
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cleaning = 0;
		cleanArea(r, c);
		System.out.println(cleaning);
	}
	
	public static void cleanArea(int r, int c) {
		int row, col;
		if (map[r][c] == 0) {
			map[r][c] = 2;
			cleaning++;
		}
		for (int i=0; i<4; i++) {
			direction = (direction+3) % 4;
			row = r + dr[direction];
			col = c + dc[direction];
			if (map[row][col] == 0) {
				cleanArea(row, col);
				return;
			}
		}
		row = r + dr[(direction+2) % 4];
		col = c + dc[(direction+2) % 4];
		if (map[row][col] == 1)
			return;
		else
			cleanArea(row, col);
	}

}
