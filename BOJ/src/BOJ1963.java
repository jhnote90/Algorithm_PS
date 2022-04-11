import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1963 {
	static int A;
	static int B;
	static int[] visited;
	static boolean[] isPrime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		isPrime = new boolean[10000];
		Arrays.fill(isPrime, true);
		for (int i=2; i<=100; i++) {
			if (isPrime[i]) {
				for (int j=i; i*j<10000; j++)
					isPrime[i*j] = false;
			}
		}
		visited = new int[10000];
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			Arrays.fill(visited, 0);
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if (A == B) {
				sb.append(0).append("\n");
				continue;
			}
			bfs();
			if (visited[B] == 0)
				sb.append("Impossible\n");
			else
				sb.append(visited[B]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(A);
		int num, temp;
		int[] p = new int[4];
		while (!q.isEmpty()) {
			num = q.remove();
			if (num == B)
				return;
			temp = num;
			for (int i=3; i>=0; i--) {
				p[i] = temp % 10;
				temp /= 10;
			}
			// 천의 자리
			for (int i=num-(p[0]-1)*1000; i<10000; i+=1000) {
				if (i == A)
					continue;
				if (isPrime[i] && visited[i] == 0) {
					visited[i] = visited[num] + 1;
					q.add(i);
				}
			}
			// 백의 자리
			temp = num - p[1] * 100;
			for (int i=0; i<1000; i+=100) {
				if (temp+i == A)
					continue;
				if (isPrime[temp+i] && visited[temp+i] == 0) {
					visited[temp+i] = visited[num] + 1;
					q.add(temp+i);
				}
			}
			// 십의 자리
			temp = num - p[2] * 10;
			for (int i=0; i<100; i+=10) {
				if (temp+i == A)
					continue;
				if (isPrime[temp+i] && visited[temp+i] == 0) {
					visited[temp+i] = visited[num] + 1;
					q.add(temp+i);
				}
			}
			// 일의 자리
			temp = num - p[3];
			for (int i=0; i<10; i++) {
				if (temp+i == A)
					continue;
				if (isPrime[temp+i] && visited[temp+i] == 0) {
					visited[temp+i] = visited[num] + 1;
					q.add(temp+i);
				}
			}
		}
	}

}
