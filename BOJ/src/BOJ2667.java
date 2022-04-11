import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2667 {
	static int n, cnt;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int complex = 0;
		String str;
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<n; i++) {
			str = br.readLine();
			for (int j=0; j<n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (map[i][j] == 1) {
					complex++;
					cnt = 0;
					search(i, j);
					list.add(cnt);
				}
			}
		}
		sb.append(complex).append("\n");
		Collections.sort(list);
		for (int i : list)
			sb.append(i).append("\n");
		System.out.print(sb);
	}
	
	public static void search(int row, int col) {
		if (row < 0 || row >= n)
			return;
		if (col < 0 || col >= n)
			return;
		if (map[row][col] == 0)
			return;
		cnt++;
		map[row][col] = 0;
		search(row+1, col);
		search(row, col+1);
		search(row-1, col);
		search(row, col-1);
		return;
	}

}
