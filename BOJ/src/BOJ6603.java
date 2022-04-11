import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
	static int k;
	static int[] S;
	static int[] sol;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		sol = new int[6];
		while (true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;
			S = new int[k];
			for (int i=0; i<k; i++)
				S[i] = Integer.parseInt(st.nextToken());
			for (int i=0; i<=k-6; i++) {
				sol[0] = S[i];
				dfs(i, 1);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void dfs(int n, int depth) {
		if (depth == 6) {
			for (int i=0; i<6; i++)
				sb.append(sol[i]).append(' ');
			sb.append("\n");
			return;
		}
		for (int i=n+1; i<=k-6+depth; i++) {
			sol[depth] = S[i];
			dfs(i, depth+1);
		}
	}
}
