import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class DragonCurve{
	int r; // y좌표
	int c; // x좌표
	int d;
	int g;
	static int[] dr = new int[] {0, -1, 0, 1};
	static int[] dc = new int[] {1, 0, -1, 0};
	
	public DragonCurve(int r, int c, int d, int g) {
		this.r = r;
		this.c = c;
		this.d = d;
		this.g = g;
	}
	
	public void drawCurve(boolean[][] visited) {
		List<Integer> list = new ArrayList<>();
		Deque<Integer> deque = new LinkedList<>();
		visited[r][c] = true;
		r += dr[d];
		c += dc[d];
		list.add(d);
		visited[r][c] = true;
		for (int i=1; i<=g; i++) {
			for (int dir : list) {
				deque.addLast((dir + 1) % 4);
			}
			while (!deque.isEmpty()) {
				int dir = deque.removeLast();
				r += dr[dir];
				c += dc[dir];
				list.add(dir);
				visited[r][c] = true;
			}
		}
		
	}
}

public class BOJ15685 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[101][101];
		DragonCurve dragonCurve;
		StringTokenizer st;
		int r, c, d, g;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			dragonCurve = new DragonCurve(r, c, d, g);
			dragonCurve.drawCurve(visited);
		}
		int cnt = 0;
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if (visited[i][j] && visited[i+1][j] && visited[i][j+1] && visited[i+1][j+1])
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
