import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2011 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cipher = br.readLine();
		int n = cipher.length();
		int temp;
		int[] C = new int[n+1];
		int[] dp = new int[n+1];
		for (int i=1; i<=n; i++)
			C[i] = cipher.charAt(n-i) - '0';
		if (C[1] == 0)
			dp[1] = 0;
		else
			dp[1] = 1;
		dp[0] = 1;
		for (int i=2; i<=n; i++) {
			if (C[i] == 0)
				dp[i] = 0;
			else {
				dp[i] = dp[i-1];
				temp = C[i] * 10 + C[i-1];
				if (temp <= 26)
					dp[i] += dp[i-2];
			}
			dp[i] = dp[i] % 1000000;
		}
		System.out.println(dp[n]);

	}

}
