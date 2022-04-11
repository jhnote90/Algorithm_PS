import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2186 {
	static int n, m, k;
	static char[][] dial;
	static int[][] dp;
	static String word;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dial = new char[n][m];
		String str;
		for (int i=0; i<n; i++) {
			str = br.readLine();
			for (int j=0; j<m; j++)
				dial[i][j] = str.charAt(j);
		}
		word = br.readLine();
		dp = new int[word.length()][n*m];
		for (int i=0; i<word.length(); i++) {
			for (int j=0; j<n*m; j++)
				dp[i][j] = -1;
		}
		int cnt = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (dial[i][j] == word.charAt(0))
					cnt += dfs(i, j, 1);
			}
		}
		System.out.println(cnt);
	}

	public static int dfs(int row, int col, int depth) {
		if (depth == word.length()) {
			return 1;
		}
		int num = m*row + col;
		if (dp[depth][num] >= 0)
			return dp[depth][num];
		int cnt = 0;
		for (int i=1; i<=k; i++) {
			if ((row-i >= 0) && (dial[row-i][col] == word.charAt(depth)))
				cnt += dfs(row-i, col, depth+1);
			if ((row+i < n) && (dial[row+i][col] == word.charAt(depth)))
				cnt += dfs(row+i, col, depth+1);
			if ((col-i >= 0) && (dial[row][col-i] == word.charAt(depth)))
				cnt += dfs(row, col-i, depth+1);
			if ((col+i < m) && (dial[row][col+i] == word.charAt(depth)))
				cnt += dfs(row, col+i, depth+1);
		}
		dp[depth][num] = cnt;
		return cnt;
	}
	
}
