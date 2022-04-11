import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2580 {
	static int[][] sdoku;
	static int blank;
	static List<Integer> blankList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sdoku = new int[9][9];
		StringTokenizer st;
		blankList = new ArrayList<>();
		for (int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				sdoku[i][j] = Integer.parseInt(st.nextToken());
				if (sdoku[i][j] == 0) {
					blank++;
					blankList.add(i*9 + j);
				}
			}
		}
		dfs(0);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++)
				sb.append(sdoku[i][j]).append(' ');
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static boolean dfs(int depth) {
		if (depth == blank)
			return true;
		int row = blankList.get(depth) / 9;
		int col = blankList.get(depth) % 9;
		for (int i=1; i<=9; i++) {
			if (promising(row, col, i)) {
				sdoku[row][col] = i;
				if (dfs(depth+1))
					return true;
				sdoku[row][col] = 0;
			}
		}
		return false;
	}
	
	public static boolean promising(int r, int c, int n) {
		for (int i=0; i<9; i++) {
			if ((sdoku[r][i] == n) || (sdoku[i][c] == n))
				return false;
		}
		int startR = r/3 * 3;
		int startC = c/3 * 3;
		for (int i=startR; i<startR+3; i++) {
			for (int j=startC; j<startC+3; j++) {
				if (sdoku[i][j] == n)
					return false;
			}
		}
		return true;
	}

}
