import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {
	static int[][] box;
	static int m, n, cnt;
	static Queue<Integer> row, col;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		box = new int[n][m];
		int day = 0;
		int r, c, size;
		row = new LinkedList<>();
		col = new LinkedList<>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) 
				box[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (box[i][j] == 1) {
					box[i][j] = 2;
					row.add(i);
					col.add(j);
				}
			}
		}
		while (true) {
			cnt = 0;
			size = row.size();
			for (int i=0; i<size; i++) {
				r = row.remove();
				c = col.remove();
				ripe(r-1, c);
				ripe(r, c+1);
				ripe(r+1, c);
				ripe(r, c-1);
			}
			if (cnt == 0)
				break;
			day++;
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (box[i][j] == 0)
					day = -1;
			}
		}
		System.out.println(day);
	}
	
	public static void ripe(int r, int c) {
		if (r < 0 || r >= n)
			return;
		if (c < 0 || c >= m)
			return;
		if (box[r][c] == 0) {
			box[r][c] = 1;
			row.add(r);
			col.add(c);
			cnt++;
		}
	}

}
