import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ14889 {
	static int n;
	static int min;
	static int[][] S;
	static int[] start;
	static int[] link;
	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		S = new int[n+1][n+1];
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		start = new int[n/2];
		link = new int[n/2];
		set = new HashSet<>();
		min = 10000;
		for (int i=1; i<=n/2+1; i++) {
			set.add(i);
			dfs(i, 1);
			set.remove(i);
		}
		System.out.println(min);
	}
	
	public static void dfs(int num, int depth) {
		if (depth == n/2) {
			int idx = 0;
			for (int i : set)
				start[idx++] = i;
			idx = 0;
			for (int i=1; i<=n; i++) {
				if (!set.contains(i))
					link[idx++] = i;
			}
			int sSum = 0;
			int lSum = 0;
			for (int i=0; i<n/2; i++) {
				for (int j=0; j<n/2; j++) {
					sSum += S[start[i]][start[j]];
					lSum += S[link[i]][link[j]];
				}
			}
			int diff = Math.abs(sSum - lSum);
			if (diff < min)
				min = diff;
			return;
		}
		
		for (int i=num+1; i<=n/2+depth+1; i++) {
			set.add(i);
			dfs(i, depth+1);
			set.remove(i);
		}
	}

}
