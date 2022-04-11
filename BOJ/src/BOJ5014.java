import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {
	static int F, G, U, D;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new int[F+1];
		bfs(S);
		if (visited[G] == -1)
			System.out.println("use the stairs");
		else
			System.out.println(visited[G]);
	}
	
	public static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		int n;
		while (!q.isEmpty()) {
			n = q.remove();
			if (n == G)
				return;
			if ((n+U <= F) && (visited[n+U] == 0) && (n+U != s)) {
				visited[n+U] = visited[n] + 1;
				q.add(n+U);
			}
			if ((n-D >= 1) && (visited[n-D] == 0) && (n-D != s)) {
				visited[n-D] = visited[n] + 1;
				q.add(n-D);
			}
		}
		visited[G] = -1;
	}

}
