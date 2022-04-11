import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		int[] T = new int[n+1];
		int[] P = new int[n+1];
		StringTokenizer st;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		int[] D = new int[n+2];
		D[n+1] = 0;
		for (int i=n; i>0; i--) {
			D[i] = D[i+1];
			if (i+T[i] <= n+1) {
				D[i] = Math.max(D[i], P[i]+D[i+T[i]]);
			}
		}
		System.out.println(D[1]);
	}

}
