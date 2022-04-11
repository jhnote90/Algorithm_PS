import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
	static List<ArrayList<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x, y;
		int connectedComponent = 0;
		visited = new boolean[n+1];
		graph = new ArrayList<>();
		for (int i=0; i<=n; i++)
			graph.add(new ArrayList<>());
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		for (int i=1; i<=n; i++) {
			if (!visited[i]) {
				bfs(i);
				connectedComponent++;
			}
		}
		System.out.println(connectedComponent);
	}
	
//	public static void dfs(int v) {
//		visited[v] = true;
//		for (int i : graph.get(v)) {
//			if (!visited[i])
//				dfs(i);
//		}
//	}
	
	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		visited[v] = true;
		q.add(v);
		while (!q.isEmpty()) {
			for (int i : graph.get(q.remove())) {
				if (!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}
