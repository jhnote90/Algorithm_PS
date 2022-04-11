import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {
	static int A;
	static int B;
	static boolean[] visited;
	static StringBuilder sb;
	
	static class DSLR {
		int num;
		StringBuilder command;
		
		public DSLR(int num) {
			this.num = num;
			command = new StringBuilder();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		visited = new boolean[10000];
		sb = new StringBuilder();
		while (t-- > 0) {
			Arrays.fill(visited, false);
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			bfs();
		}
		System.out.println(sb);
	}
	
	public static void bfs() {
		Queue<DSLR> q = new LinkedList<>();
		visited[A] = true;
		DSLR dslr = new DSLR(A);
		q.add(dslr);
		int[] p = new int[4];
		int n;
		DSLR toAdd;
		while (!q.isEmpty()) {
			dslr = q.remove();
			if (dslr.num == B) {
				sb.append(dslr.command.toString()).append("\n");
				return;
			}
			p[0] = dslr.num / 1000;
			p[1] = dslr.num / 100 % 10;
			p[2] = dslr.num / 10 % 10;
			p[3] = dslr.num % 10;
			// D
			n = dslr.num * 2 % 10000;
			if (!visited[n]) {
				visited[n] = true;
				toAdd = new DSLR(n);
				toAdd.command.append(dslr.command.toString());
				toAdd.command.append('D');
				q.add(toAdd);
			}
			// S
			if (dslr.num == 0)
				n = 9999;
			else
				n = dslr.num - 1;
			if (!visited[n]) {
				visited[n] = true;
				toAdd = new DSLR(n);
				toAdd.command.append(dslr.command.toString());
				toAdd.command.append('S');
				q.add(toAdd);
			}
			// L
			n = p[1]*1000 + p[2]*100 + p[3]*10 + p[0];
			if (!visited[n]) {
				visited[n] = true;
				toAdd = new DSLR(n);
				toAdd.command.append(dslr.command.toString());
				toAdd.command.append('L');
				q.add(toAdd);
			}
			// R
			n = p[3]*1000 + p[0]*100 + p[1]*10 + p[2];
			if (!visited[n]) {
				visited[n] = true;
				toAdd = new DSLR(n);
				toAdd.command.append(dslr.command.toString());
				toAdd.command.append('R');
				q.add(toAdd);
			}
		}
		
	}

}
