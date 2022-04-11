import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15684 {
	static int n;
	static int m;
	static int h;
	static int addLine;
	static boolean[][] rowLine;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		rowLine = new boolean[h+1][n+1];
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			rowLine[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;	
		}
		list = new ArrayList<>();
		for (int i=1; i<=h; i++) {
			for (int j=1; j<n; j++) {
				if (!rowLine[i][j])
					list.add(n*i + j);
			}
		}
		addLine = -1;
		dfs(0, -1);
		System.out.println(addLine);
	}
	
	public static void dfs(int depth, int idx) {
		if (addLine != -1 && depth >= addLine)
			return;
		boolean check = true;
		int cur;
		for (int i=1; i<=n; i++) {
			cur = i;
			for (int j=1; j<=h; j++) {
				if (rowLine[j][cur-1] && rowLine[j][cur])
					return;
				if (rowLine[j][cur-1]) {
					cur--;
				}
				else if (rowLine[j][cur]) {
					cur++;
				}
			}
			if (cur != i) {
				check = false;
				break;
			}
		}
		if (check) {
			addLine = depth;
			return;
		}
		if (depth == 3 || idx+1 >= list.size())
			return;
		for (int i=idx+1; i<list.size(); i++) {
			int num = list.get(i);
			rowLine[num/n][num%n] = true;
			dfs(depth+1, i);
			rowLine[num/n][num%n] = false;
		}
	}

}
