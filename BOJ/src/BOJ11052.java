import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] P = new int[n+1];
		int[] dp = new int[n+1];
		int temp;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++)
			P[i] = Integer.parseInt(st.nextToken());
		dp[1] = P[1];
		for (int i=2; i<=n; i++) {
			dp[i] = P[i];
			for (int j=1; j<=i/2; j++) {
				temp = dp[j] + dp[i-j];
				if (temp > dp[i])
					dp[i] = temp;
			}
		}
		System.out.println(dp[n]);
	}

}
