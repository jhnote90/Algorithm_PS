import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
	static int n;
	static int k;
	static int time;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		time = 0;
		visited = new boolean[100001];
		bfs(n);
		System.out.println(time);
	}
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		visited[n] = true;
		q.add(n);
		int v;
		int size = 1;
		while (!q.isEmpty()) {
			for (int i=0; i<size; i++) {
				v = q.remove();
				if (v == k)
					return;
				if (promising(v-1)) {
					visited[v-1] = true;
					q.add(v-1);
				}
				if (promising(v+1)) {
					visited[v+1] = true;
					q.add(v+1);
				}
				if (promising(v*2)) {
					visited[v*2] = true;
					q.add(v*2);
				}
			}
			size = q.size();
			time++;
		}
	}
	
	public static boolean promising(int v) {
		if (v < 0 || v > 100000)
			return false;
		if (visited[v])
			return false;
		return true;
	}

}
