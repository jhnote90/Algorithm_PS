import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {
	static int[][] map;
	static int w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int islands;
		String str;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			islands = 0;
			str = br.readLine();
			if (str.equals("0 0"))
				break;
			st = new StringTokenizer(str);
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			for (int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<w; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i=0; i<h; i++) {
				for (int j=0; j<w; j++) {
					if (map[i][j] == 1) {
						search(i, j);
						islands++;
					}
				}
			}
			sb.append(islands).append("\n");
		}
		System.out.print(sb);
	}
	
	public static void search(int row, int col) {
		if (row < 0 || row >= h)
			return;
		if (col < 0 || col >= w)
			return;
		if (map[row][col] == 0)
			return;
		map[row][col] = 0;
		for (int i=-1; i<=1; i++) {
			for (int j=-1; j<=1; j++)
				search(row+i, col+j);
		}
	}

}
