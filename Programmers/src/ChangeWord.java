import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ChangeWord {
	static int n, len;
	static String begin;
	static String target;
	static String[] words;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		begin = br.readLine();
		target = br.readLine();
		words = new String[n];
		for (int i=0; i<n; i++) {
			words[i] = br.readLine();
		}
		visited = new boolean[n];
		len = begin.length();
		int cnt = bfs(begin);
		System.out.println(cnt);
	}
	
	public static int bfs(String s) {
		Queue<String> q = new LinkedList<>();
		q.offer(s);
		String str;
		int ret = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				str = q.poll();
				if (str.equals(target))
					return ret;
				for (int i=0; i<n; i++) {
					if (visited[i])
						continue;
					int cnt = 0;
					for (int j=0; j<len; j++) {
						if (str.charAt(j) != words[i].charAt(j))
							cnt++;
					}
					if (cnt == 1) {
						visited[i] = true;
						q.offer(words[i]);
					}
				}
			}
			ret++;
		}
		return 0;
	}

}
