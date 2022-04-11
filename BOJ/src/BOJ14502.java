import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14502 {
	static int n;
	static int m;
	static int max;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	static int[][] map;
	static List<List<Integer>> blank;
	static List<List<Integer>> virus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		blank = new ArrayList<>();
		virus = new ArrayList<>();
		List<Integer> list;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				list = new ArrayList<>();
				list.add(i);
				list.add(j);
				if (map[i][j] == 0)
					blank.add(list);
				else if (map[i][j] == 2)
					virus.add(list);
			}
		}
		max = 0;
		cbn(-1, 0);
		System.out.println(max);
	}
	
	public static void cbn(int num, int depth) {
		int row, col;
		if (depth == 3) {
			int safeArea = 0;
			for (List<Integer> l : virus) {
				row = l.get(0);
				col = l.get(1);
				for (int j=0; j<4; j++)
					dfs(row+dr[j], col+dc[j]);
			}
			for (int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					if (map[i][j] == 0)
						safeArea++;
					else if (map[i][j] == -1)
						map[i][j] = 0;
				}
			}
			if (safeArea > max)
				max = safeArea;
			return;
		}
		for (int i=num+1; i<blank.size()-2+depth; i++) {
			row = blank.get(i).get(0);
			col = blank.get(i).get(1);
			map[row][col] = 1;
			cbn(i, depth+1);
			map[row][col] = 0;
		}
	}
	
	public static void dfs(int r, int c) {
		if (r<0 || r>=n || c<0 || c>=m || map[r][c] != 0)
			return;
		map[r][c] = -1;
		for (int i=0; i<4; i++)
			dfs(r+dr[i], c+dc[i]);
	}

}
