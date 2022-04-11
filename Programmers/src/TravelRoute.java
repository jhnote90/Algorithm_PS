import java.util.Arrays;
import java.util.Comparator;

public class TravelRoute {
	static int n;
	static boolean[] visited;
	static String[] sol;

	public static void main(String[] args) {
		String[][] tickets = new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if (o1[0].equals(o2[0]))
					return o1[1].compareTo(o2[1]);
				return o1[0].compareTo(o2[0]);
			}
		});
		n = tickets.length;
		visited = new boolean[n];
		sol = new String[n+1];
		sol[0] = "ICN";
		dfs(0, tickets);
		for (int i=0; i<n+1; i++)
			System.out.println(sol[i]);
	}
	
	public static boolean dfs(int depth, String[][] tickets) {
		if (depth == n)
			return true;
		for (int i=0; i<n; i++) {
			if (!visited[i] && sol[depth].equals(tickets[i][0])) {
				visited[i] = true;
				sol[depth+1] = tickets[i][1];
				if (dfs(depth+1, tickets))
					return true;
				visited[i] = false;
			}
		}
		return false;
	}

}
