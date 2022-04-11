import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
	static int n, s;
	static int cnt;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		cnt = 0;
		dfs(-1, 0);
		System.out.println(cnt);
	}
	
	public static void dfs(int idx, int sum) {
		if (idx != -1 && sum == s)
			cnt++;
		for (int i=idx+1; i<n; i++)
			dfs(i, sum+arr[i]);
	}

}
