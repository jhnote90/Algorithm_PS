import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int result;
		int[][] dp = new int[k+1][n+1]; // 정수 k개의 합이 n 이하기 되는 경우의 수
		for (int i=0; i<=n; i++)
			dp[1][i] = i+1;
		for (int i=2; i<k; i++) {
			dp[i][0] = 1;
			for (int j=1; j<=n; j++) 
				dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
		}
		if (k>1)
			result = dp[k-1][n];
		else
			result = 1;
		System.out.println(result);
	}

}
