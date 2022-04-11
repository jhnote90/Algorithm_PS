import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Network {
	static int n;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] computers = new int[n][n];
		int answer = 0;
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++)
				computers[i][j] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[n];
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				answer++;
				dfs(i, computers);
			}
		}
		System.out.println(answer);
	}
	
	public static void dfs(int v, int[][] computers) {
		visited[v] = true;
		for (int i=0; i<n; i++) {
			if (!visited[i] && computers[v][i] == 1)
				dfs(i, computers);
		}
	}

}
