import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {

	public static void main(String[] args) throws IOException {
		int t, n;
		StringTokenizer st;
		int[][] S = new int[2][100001];
		int[][] P = new int[2][100001];
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=n; i++)
				S[0][i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=n; i++)
				S[1][i] = Integer.parseInt(st.nextToken());
			P[0][1] = S[0][1]; P[1][1] = S[1][1];
			P[0][2] = P[1][1] + S[0][2];
			P[1][2] = P[0][1] + S[1][2];
			
			for (int i=3; i<=n; i++) {
				P[0][i] = Math.max(P[1][i-1], P[1][i-2]) + S[0][i];
				P[1][i] = Math.max(P[0][i-1], P[0][i-2]) + S[1][i];
			}
			sb.append(Math.max(P[0][n], P[1][n])).append("\n");
		}
		System.out.println(sb);
		

	}

}
