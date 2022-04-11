import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;


public class BOJ2583 {
	static int m, n, k;
	static int area;
	static int[][] paper;
	static int[] dr = new int[] {1, 0, -1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		paper = new int[m][n];
		int r1, c1, r2, c2;
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			for (int j=r1; j<r2; j++) {
				for (int k=c1; k<c2; k++) {
					paper[j][k] = 1;
				}
			}
		}
		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (paper[i][j] == 0) {
					area = 0;
					dfs(i, j);
					list.add(area);
					cnt++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		Collections.sort(list);
		for (int i : list)
			sb.append(i).append(' ');
		System.out.println(sb);
	}
	
	public static void dfs(int r, int c) {
		paper[r][c] = 1;
		area++;
		int row, col;
		for (int i=0; i<4; i++) {
			row = r + dr[i];
			col = c + dc[i];
			if ((row < 0) || (row >= m) || (col < 0) || (col >= n))
				continue;
			if (paper[row][col] == 0)
				dfs(row, col);
		}
	}

}
