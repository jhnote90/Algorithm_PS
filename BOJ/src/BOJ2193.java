import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] P = new long[n+1][2];
		P[1][0] = 1L; P[1][1] = 1L;
		for (int i=2; i<n+1; i++) {
			P[i][0] = P[i-1][0] + P[i-1][1];
			P[i][1] = P[i-1][0];
		}
		System.out.println(P[n][1]);

	}

}
