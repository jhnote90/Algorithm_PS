import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
	static List<ArrayList<Integer>> graph;
	static boolean[] visit; 
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int x, y;
		visit = new boolean[n+1];
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
		for (ArrayList<Integer> list : graph)
			Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		dfs(v, sb);
		sb.append("\n");
		Arrays.fill(visit, false);
		bfs(v, sb);
		System.out.println(sb);
 	}

	public static void dfs(int v, StringBuilder sb) {
		visit[v] = true;
		sb.append(v).append(' ');
		for (int i : graph.get(v)) {
			if (!visit[i])
				dfs(i, sb);
		}
	}
	
	public static void bfs(int v, StringBuilder sb) {
		Queue<Integer> q = new LinkedList<>();
		visit[v] = true;
		q.add(v);
		sb.append(v).append(' ');
		while (!q.isEmpty()) {
			for (int i : graph.get(q.remove())) {
				if (!visit[i]) {
					visit[i] = true;
					q.add(i);
					sb.append(i).append(' ');
				}
			}
		}
	}
}
