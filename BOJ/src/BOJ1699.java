import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1699 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		int pow = 1;
		dp[1] = 1;
		int temp;
		for (int i=2; i<=n; i++) {
			if (i == (pow+1)*(pow+1)) {
				dp[i] = 1;
				pow++;
			}
			else {
				dp[i] = i;
				for (int j=pow; j>0; j--) {
					temp = dp[j*j] + dp[i-(j*j)];
					if (temp < dp[i])
						dp[i] = temp;
				}
			}
		}
		System.out.println(dp[n]);
	}

}
