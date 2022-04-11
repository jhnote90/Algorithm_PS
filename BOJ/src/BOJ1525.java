import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1525 {
	static int sol;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int num;
		for (int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				num = Integer.parseInt(st.nextToken());
				if (num == 0)
					sb.append(9);
				else
					sb.append(num);
			}
		}
		int begin = Integer.parseInt(sb.toString());
		sol = 123456789;
		map = new HashMap<>();
		bfs(begin);
		System.out.println(map.get(sol));
	}
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		map.put(n, 0);
		q.add(n);
		int num, idx, row, col, swapIdx;
		int r, c, addNum;
		String str;
		StringBuilder sb;
		while (!q.isEmpty()) {
			num = q.remove();
			if (num == sol)
				return;
			str = num + "";
			for (idx=0; idx<9; idx++) {
				if (str.charAt(idx) == '9')
					break;
			}
			row = idx / 3;
			col = idx % 3;
			for (int i=0; i<4; i++) {
				r = row + dr[i];
				c = col + dc[i];
				if ((r >= 0) && (r < 3) && (c >= 0) && (c < 3)) {
					sb = new StringBuilder(str);
					swapIdx = r*3 + c;
					sb.setCharAt(idx, sb.charAt(swapIdx));
					sb.setCharAt(swapIdx, '9');
					addNum = Integer.parseInt(sb.toString());
					if (!map.containsKey(addNum)) {
						map.put(addNum, map.get(num)+1);
						q.add(addNum);
					}
				}
			}
		}
		map.put(sol, -1);
	}

}
