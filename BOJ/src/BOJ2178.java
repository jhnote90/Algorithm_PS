import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
	static int n, m, dist;
	static int[][] maze;
	static boolean[][] visited;
	static Queue<Integer> row, col;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dist = 0;
		maze = new int[n][m];
		visited = new boolean[n][m];
		row = new LinkedList<>();
		col = new LinkedList<>();
		for (int i=0; i<n; i++) {
			str = br.readLine();
			for (int j=0; j<m; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0, 0);
		System.out.println(dist);
	}
	
	public static void bfs(int r, int c) {
		int qSize, pr, pc, cr, cc;
		visited[r][c] = true;
		row.add(r);
		col.add(c);
		while (!row.isEmpty()) {
			dist++;
			qSize = row.size();
			for (int i=0; i<qSize; i++) {
				pr = row.remove();
				pc = col.remove();
				if (pr == n-1 && pc == m-1)
					return;
				for (int j=0; j<4; j++) {
					cr = pr + dr[j];
					cc = pc + dc[j];
					if (cr < 0 || cr >= n)
						continue;
					if (cc < 0 || cc >= m)
						continue;
					if (maze[cr][cc] == 0 || visited[cr][cc])
						continue;
					visited[cr][cc] = true;
					row.add(cr);
					col.add(cc);
				}
			}
		}
	}

}
