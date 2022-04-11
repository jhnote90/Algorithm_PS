import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
	static int n;
	static int max;
	static int min;
	static int[] A;
	static int[] opt;
	static int[] sol;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) 
			A[i] = Integer.parseInt(st.nextToken());
		opt = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++)
			opt[i] = Integer.parseInt(st.nextToken());
		sol = new int[n-1];
		max = -1000000000;
		min = 1000000000;
		dfs(0);
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void dfs(int depth) {
		if (depth == n-1) {
			calc();
			return;
		}
		for (int i=0; i<4; i++) {
			if (opt[i] > 0) {
				opt[i]--;
				sol[depth] = i;
				dfs(depth+1);
				opt[i]++;
			}
		}
	}
	
	public static void calc() {
		int num = A[0];
		for (int i=0; i<n-1; i++) {
			switch (sol[i]) {
			case 0:
				num += A[i+1];
				break;
			case 1:
				num -= A[i+1];
				break;
			case 2:
				num *= A[i+1];
				break;
			case 3:
				num /= A[i+1];
				break;
			}
		}
		if (num > max)
			max = num;
		if (num < min)
			min = num;
	}

}
