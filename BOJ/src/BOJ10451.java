import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10451 {
	static List<ArrayList<Integer>> graph;
	static boolean[] visited;
	static boolean[] finished;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int n, pCycle;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			pCycle = 0;
			n = Integer.parseInt(br.readLine());
			graph = new ArrayList<>();
			for (int i=0; i<=n; i++)
				graph.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=n; i++)
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			visited = new boolean[n+1];
			finished = new boolean[n+1];
			for (int i=1; i<=n; i++) {
				if (!visited[i]) {
					if (hasCycle(i))
						pCycle++;
				}
			}
			sb.append(pCycle).append("\n");
		}
		System.out.println(sb);

	}
	
	public static boolean hasCycle(int v) {
		visited[v] = true;
		for (int i : graph.get(v)) {
			if (!visited[i]) {
				if(hasCycle(i))
					return true;
			}
			else if (!finished[i])
				return true;
		}
		finished[v] = true;
		return false;
	}

}
