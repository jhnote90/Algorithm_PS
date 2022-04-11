import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9466 {
//	static List<ArrayList<Integer>> graph;
	static int[] graph;
	static boolean[] visited;
	static boolean[] finished;
	static int[] team;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int n, result;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (t-- > 0) {
			result = 0;
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
//			graph = new ArrayList<>();
//			for (int i=0; i<=n; i++)
//				graph.add(new ArrayList<>());
//			for (int i=1; i<=n; i++)
//				graph.get(i).add(Integer.parseInt(st.nextToken()));
			graph = new int[n+1];
			for (int i=1; i<=n; i++)
				graph[i] = Integer.parseInt(st.nextToken());
			visited = new boolean[n+1];
			finished = new boolean[n+1];
			team = new int[n+1];
			for (int i=1; i<=n; i++) {
				if (!visited[i])
					dfsCycle(i);
			}
			for (int i=1; i<=n; i++) {
				if (team[i] == 0)
					result++;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean dfsCycle(int v) {
		visited[v] = true;
//		for (int i : graph.get(v)) {
		int i = graph[v];
		if (!visited[i]) {
			if (dfsCycle(i)) {
				team[v] = team[i];
				finished[v] = true;
				if (v == team[i])
					return false;
				return true;
			}
		}
		else if (!finished[i]) {
			team[v] = i;
			finished[v] = true;
			if (v == i)
				return false;
			return true;
		}
//		}
		finished[v] = true;
		return false;
	}

}
