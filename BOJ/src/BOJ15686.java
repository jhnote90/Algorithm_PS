import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {
	static int n;
	static int m;
	static int cityDist;
	static int chickenSize;
	static int[] sol;
	static int[][] city;
	static List<List<Integer>> chickens;
	static List<List<Integer>> houses;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		city = new int[n][n];
		sol = new int[m];
		chickens = new ArrayList<>();
		houses = new ArrayList<>();
		List<Integer> list;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == 1) {
					list = new ArrayList<>();
					list.add(i);
					list.add(j);
					houses.add(list);
				}
				else if (city[i][j] == 2) {
					list = new ArrayList<>();
					list.add(i);
					list.add(j);
					chickens.add(list);
				}
			}
		}
		cityDist = Integer.MAX_VALUE;
		chickenSize = chickens.size();
		dfs(-1, 0);
		System.out.println(cityDist);
	}
	
	public static void dfs(int num, int depth) {
		if (depth == m) {
			int dist, chickenDist;
			int sum = 0;
			for (List<Integer> h : houses) {
				chickenDist = Integer.MAX_VALUE;
				for (int i=0; i<sol.length; i++) {
					dist = Math.abs(chickens.get(sol[i]).get(0) - h.get(0));
					dist += Math.abs(chickens.get(sol[i]).get(1) - h.get(1));
					chickenDist = Math.min(chickenDist, dist);
				}
				sum += chickenDist;
			}
			cityDist = Math.min(cityDist, sum);
			return;
		}
		for (int i=num+1; i<=chickenSize-m+depth; i++) {
			sol[depth] = i;
			dfs(i, depth+1);
		}
	}

}
