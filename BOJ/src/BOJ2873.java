import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2873 {
	static int[][] map;
	static int r;
	static int c;
	static int blank_row, blank_col;
	static int[] rowSection;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r+1][c+1];
		for (int i=1; i<=r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=c; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		sb = new StringBuilder();
		if (r%2 == 1) {
			for (int i=1; i<=r; i++) {
				for (int j=1; j<=c-1; j++) {
					if (i%2 == 1)
						sb.append('R');
					else
						sb.append('L');
				}
				if (i == r)
					break;
				sb.append('D');
			}
		}
		else if (c%2 == 1) {
			for (int i=1; i<=c; i++) {
				for (int j=1; j<=r-1; j++) {
					if (i%2 == 1)
						sb.append('D');
					else
						sb.append('U');
				}
				if (i == c)
					break;
				sb.append('R');
			}
		}
		else {
			int min = 1000;
			for (int i=1; i<=r; i++) {
				for (int j=1; j<=c; j++) {
					if ((i+j)%2 == 0)
						continue;
					if (map[i][j] < min) {
						min = map[i][j];
						blank_row = i;
						blank_col = j;
					}
				}
			}
			map[blank_row][blank_col] = 0;
			if (blank_row%2 == 1)
				rowSection = new int[] {blank_row, blank_row+1};
			else
				rowSection = new int[] {blank_row-1, blank_row};
			rollerCoaster(1, 1);
		}
		System.out.println(sb);
	}
	
	public static void rollerCoaster(int row, int col) {
		map[row][col] = 0;
		if (row == r && col == c)
			return;
		if (row == rowSection[0]) {
			if (map[row+1][col] > 0) {
				sb.append('D');
				rollerCoaster(row+1, col);
			}
			else {
				sb.append('R');
				rollerCoaster(row, col+1);
			}
		}
		else if (row == rowSection[1]) {
			if (col == c) {
				sb.append('D');
				rollerCoaster(row+1, col);
			}
			else if (map[row-1][col] > 0) {
				sb.append('U');
				rollerCoaster(row-1, col);
			}
			else {
				sb.append('R');
				rollerCoaster(row, col+1);
			}
		}
		else {
			if ((col+1 <= c) && (map[row][col+1] > 0)) {
				sb.append('R');
				rollerCoaster(row, col+1);
			}
			else if (map[row][col-1] > 0) {
				sb.append('L');
				rollerCoaster(row, col-1);
			}
			else {
				sb.append('D');
				rollerCoaster(row+1, col);
			}
		}
		
	}

}
