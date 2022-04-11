import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {
	static int n;
	static int max;
	static int[] A;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		A = new int[n+1];
		visited = new boolean[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		max = 0;
		int[] sol = new int[n+1];
		backTracking(sol, 0);
		System.out.println(max);
	}
	
	public static void backTracking(int[] sol, int depth) {
		if (depth == n) {
			int temp = 0;
			for (int i=1; i<=n-1; i++)
				temp += Math.abs(sol[i] - sol[i+1]);
			if (temp > max)
				max = temp;
		}
		for (int i=1; i<=n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sol[depth+1] = A[i];
				backTracking(sol, depth+1);
				visited[i] = false;
			}
		}
	}

}
