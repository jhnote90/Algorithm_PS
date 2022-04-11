import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] G = new int[n+1];
		int[][] Q = new int[n+1][2];
		for (int i=1; i<=n; i++)
			G[i] = Integer.parseInt(br.readLine());
		Q[1][0] = 0; Q[1][1] = G[1];
		if (n > 1) {
			Q[2][0] = Q[1][1];
			Q[2][1] = G[1] + G[2];
		}
		for (int i=3; i<=n; i++) {
			Q[i][0] = Math.max(Q[i-1][0], Q[i-1][1]);
			Q[i][1] = Math.max(Q[i-1][0], (G[i-1] + Q[i-2][0])) + G[i];
		}
		System.out.println(Math.max(Q[n][0], Q[n][1]));

	}

}
