import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1967 {
	static int n;
	static int diameter;
	static int maxV;
	static boolean[] visited;
	static List<ArrayList<Node>> graph;
	
	static class Node {
		int num;
		int weight;
		
		public Node (int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v, u, weight;
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		visited = new boolean[n+1];
		for (int i=0; i<=n; i++)
			graph.add(new ArrayList<>());
		StringTokenizer st;
		for (int i=1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			graph.get(v).add(new Node(u, weight));
			graph.get(u).add(new Node(v, weight));
		}
		diameter = 0;
		dfs(1, 0);
		Arrays.fill(visited, false);
		dfs(maxV, 0);
		System.out.println(diameter);
	}
	
	public static void dfs(int v, int dist) {
		visited[v] = true;
		int cnt = 0;
		for (Node node : graph.get(v)) {
			if (!visited[node.num]) {
				dfs(node.num, dist+node.weight);
				cnt++;
			}
		}
		if (cnt == 0 && diameter < dist) {
			diameter = dist;
			maxV = v;
		}
	}

}
