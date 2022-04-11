import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10971 {
	static int n;
	static int optCost;
	static int[][] W;
	static boolean[] visited;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		W = new int[n+1][n+1];
		visited = new boolean[n+1];
		StringTokenizer st;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++)
				W[i][j] = Integer.parseInt(st.nextToken());
		}
		optCost = 100000000;
		visited[1] = true;
		backTracking(1, 1, 1, 0);
		System.out.println(optCost);
	}
	
	public static void backTracking(int start, int curr, int depth, int cost) {
		if (depth == n) {
			if (W[curr][start] == 0)
				return;
			cost += W[curr][start];
			if (cost < optCost)
				optCost = cost;
		}
		for (int i=1; i<=n; i++) {
			if (promising(i, curr, cost)) {
				visited[i] = true;
				backTracking(start, i, depth+1, cost+W[curr][i]);
				visited[i] = false;
			}
		}
	}
	
	public static boolean promising(int v, int curr, int cost) {
		if (visited[v])
			return false;
		if (W[curr][v] == 0)
			return false;
		cost += W[curr][v];
		if (cost >= optCost)
			return false;
		return true;
	}

}
