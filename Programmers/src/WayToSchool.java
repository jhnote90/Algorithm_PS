
public class WayToSchool {

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = new int[][] {{2, 2}};
		int[][] dp = new int[n][m];
		dp[0][0] = 1;
		for (int i=0; i<puddles.length; i++)
			dp[puddles[i][1]][puddles[i][0]] = -1;
		for (int i=1; i<m; i++) {
			if (dp[0][i] == -1)
				dp[0][i] = 0;
			else
				dp[0][i] = dp[0][i-1];
		}
		for (int i=1; i<n; i++) {
			if (dp[i][0] == -1)
				dp[i][0] = 0;
			else
				dp[i][0] = dp[i-1][0];
		}
		for (int i=1; i<n; i++) {
			for (int j=1; j<m; j++) {
				if (dp[i][j] == -1)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		System.out.println(dp[n-1][m-1]);
	}

}
