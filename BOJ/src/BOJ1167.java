import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1167 {
	static int V;
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
		int v, u;
		V = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		visited = new boolean[V+1];
		for (int i=0; i<=V; i++)
			graph.add(new ArrayList<>());
		StringTokenizer st;
		for (int i=1; i<=V; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			while ((u = Integer.parseInt(st.nextToken())) != -1)
				graph.get(v).add(new Node(u, Integer.parseInt(st.nextToken())));
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
