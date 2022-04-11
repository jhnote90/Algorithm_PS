import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16234 {
	static int n;
	static int L;
	static int R;
	static int union;
	static int unionNum;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	static int[][] A;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[n][n];
		visited = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		List<Integer> list;
		while (true) {
			for (int i=0; i<n; i++)
				Arrays.fill(visited[i], -1);
			unionNum = 0;
			list = new ArrayList<>();
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (visited[i][j] == -1) {
						union = 0;
						int num = dfs(i, j);
						if (union > 1) {
							list.add(num/union);
							unionNum++;
						}
						else if (union == 1)
							visited[i][j] = -2;
					}
				}
			}
			if (unionNum == 0)
				break;
			else {
				for (int i=0; i<n; i++) {
					for (int j=0; j<n; j++) {
						if (visited[i][j] >= 0)
							A[i][j] = list.get(visited[i][j]);
					}
				}
				day++;
			}
		}
		System.out.println(day);
	}
	
	public static int dfs(int r, int c) {
		visited[r][c] = unionNum;
		union++;
		int num = A[r][c];
		int row, col, diff;
		for (int i=0; i<4; i++) {
			row = r + dr[i];
			col = c + dc[i];
			if (row<0 || row>=n || col<0 || col>=n || visited[row][col] != -1)
				continue;
			diff = Math.abs(A[r][c] - A[row][col]);
			if (L <= diff && diff <= R)
				num += dfs(row, col);
		}
		return num;
	}

}
