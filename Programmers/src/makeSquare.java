import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class makeSquare {
	static int n;
	static double area;
	static int[] sol;
	static int[][] points;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sol = new int[4];
		points = new int[n][2];
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());
		}
		area = 0;
		for (int i=0; i<=n-4; i++) {
			sol[0] = i;
			dfs(1);
		}
		System.out.println(String.format("%.2f", area));
	}
	
	public static void dfs(int depth) {
		if (depth == 4) {
			square();
			return;
		}
		for (int i=sol[depth-1]+1; i<=n-(4-depth); i++) {
			sol[depth] = i;
			dfs(depth+1);
		}
	}
	
	public static void square() {
		Integer[][] p = new Integer[4][2];
		for (int i=0; i<4; i++) {
			p[i][0] = points[sol[i]][0];
			p[i][1] = points[sol[i]][1];
		}
		Arrays.sort(p, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] p1, Integer[] p2) {
				if (p1[0] == p2[0])
					return p1[1] - p2[1];
				return p1[0] - p2[0];
			}
		});
		if (((p[0][0]+p[3][0]) == (p[1][0]+p[2][0])) && ((p[0][1]+p[3][1]) == (p[1][1]+p[2][1]))) {
			int xdiff1 = p[3][0] - p[0][0];
			int xdiff2 = p[2][0] - p[1][0];
			int ydiff1 = p[3][1] - p[0][1];
			int ydiff2 = p[2][1] - p[1][1];
			if ((xdiff1 == Math.abs(ydiff2)) && (xdiff2 == Math.abs(ydiff1)) && (ydiff1 * ydiff2 < 0)) {
				double a = Math.pow(p[1][0] - p[0][0], 2) + Math.pow(Math.abs(p[1][1]-p[0][1]), 2);
				if (a > area)
					area = a;
			}
		}
	}

}
