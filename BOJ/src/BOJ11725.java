import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11725 {
	static int n;
	static int[] parent;
	static boolean[] visited;
	static List<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		visited = new boolean[n+1];
		graph = new ArrayList<>();
		int x, y;
		for (int i=0; i<=n; i++)
			graph.add(new ArrayList<>());
		StringTokenizer st;
		for (int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		dfs(1);
		StringBuilder sb = new StringBuilder();
		for (int i=2; i<=n; i++)
			sb.append(parent[i]).append("\n");
		System.out.print(sb);
	}
	
	public static void dfs(int v) {
		visited[v] = true;
		for (int i : graph.get(v)) {
			if (!visited[i]) {
				parent[i] = v;
				dfs(i);
			}
		}
	}

}
