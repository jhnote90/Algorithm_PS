import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707 {
	static List<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int[] set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int v, e, x, y;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String bipartiteGraph = null;
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			for (int i=0; i<=v; i++)
				graph.add(new ArrayList<>());
			visited = new boolean[v+1];
			set = new int[v+1];
			for (int i=0; i<e; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				graph.get(x).add(y);
				graph.get(y).add(x);
			}
			for (int i=1; i<=v; i++) {
				if (!visited[i]) {
					if (bfs(i).equals("NO")) {
						bipartiteGraph = "NO";
						break;
					}
					bipartiteGraph = "YES";
				}
			}
			sb.append(bipartiteGraph).append("\n");
		}
		System.out.println(sb);
	}
	
	private static String bfs(int v) {
		boolean[] toAlign = new boolean[3];
		int popVertex;
		Queue<Integer> q = new LinkedList<>();
		visited[v] = true;
		q.add(v);
		while (!q.isEmpty()) {
			popVertex = q.remove();
			Arrays.fill(toAlign, true);
			for (int i : graph.get(popVertex)) {
				toAlign[set[i]] = false;
				if (!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
			if (toAlign[1])
				set[popVertex] = 1;
			else if (toAlign[2])
				set[popVertex] = 2;
			else
				return "NO";
		}
		return "YES";
	}

}
