import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long[] P = new long[101];
		P[1] = 1L; P[2] = 1L; P[3] = 1L;
		P[4] = 2L; P[5] = 2L;
		for (int i=6; i<=100; i++)
			P[i] = P[i-1] + P[i-5];
		int n;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			sb.append(P[n]).append("\n");
		}
		System.out.println(sb);

	}

}
