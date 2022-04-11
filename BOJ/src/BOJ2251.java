import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ2251 {
	static int[] bots;
	static int[] water;
	static Set<Integer> visited;
	static Set<Integer> sol;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bots = new int[3];
		water = new int[3];
		for (int i=0; i<3; i++)
			bots[i] = Integer.parseInt(st.nextToken());
		visited = new HashSet<>();
		sol = new TreeSet<>();
		bfs(0, 0, bots[2]);
		StringBuilder sb = new StringBuilder();
		for (int i : sol)
			sb.append(i).append(' ');
		System.out.println(sb);
	}
	
	public static void bfs(int a, int b, int c) {
		Queue<Integer> q = new LinkedList<>();
		int n = a*1000000 + b*1000 + c;
		visited.add(n);
		q.add(n);
		int[] arr = new int[3];
		while (!q.isEmpty()) {
			n = q.remove();
			water[0] = n / 1000000;
			water[1] = n / 1000 % 1000;
			water[2] = n % 1000;
			if (water[0] == 0)
				sol.add(water[2]);
			for (int i=0; i<3; i++) {
				if (water[i] == 0)
					continue;
				for (int j=0; j<3; j++) {
					if (i == j)
						continue;
					pour(i, j, arr);
					n = arr[0]*1000000 + arr[1]*1000 + arr[2];
					if (!visited.contains(n)) {
						visited.add(n);
						q.add(n);
					}
				}
			}
		}
	}
	
	public static void pour(int s, int e, int[] arr) {
		for (int i=0; i<3; i++)
			arr[i] = water[i];
		int w1 = water[s];
		int w2 = bots[e] - water[e];
		if (w1 <= w2) {
			arr[s] = 0;
			arr[e] += w1;
		}
		else {
			arr[s] -= w2;
			arr[e] += w2;
		}
	}

}
