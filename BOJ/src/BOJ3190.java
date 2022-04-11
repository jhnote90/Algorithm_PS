import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3190 {
	static int n;
	static int time;
	static int idx;
	static int[] dr = new int[] {0, 1, 0, -1};
	static int[] dc = new int[] {1, 0, -1, 0};
	static int[][] board;
	static Queue<Integer> queue;
	static Map<Integer, Character> map;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		board = new int[n][n];
		queue = new LinkedList<>();
		map = new HashMap<>();
		time = 0;
		int r, c;
		StringTokenizer st;
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			board[r][c] = 1;
		}
		int l = Integer.parseInt(br.readLine());
		for (int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		idx = 0;
		start(0, 0);
		System.out.println(time);
	}
	
	public static void start(int r, int c) {
		if (r<0 || r>=n || c<0 || c>=n || board[r][c] == -1)
			return;
		if (board[r][c] == 1) {
			board[r][c] = -1;
			queue.offer(r*n + c);
		}
		else if (board[r][c] == 0) {
			if (!queue.isEmpty()) {
				int num = queue.poll();
				board[num/n][num%n] = 0;
			}
			board[r][c] = -1;
			queue.offer(r*n + c);
		}
		if (map.containsKey(time)) {
			char rotate = map.get(time);
			if (rotate == 'L')
				idx = (idx + 3) % 4;
			else if (rotate == 'D')
				idx = (idx + 1) % 4;
		}
		time++;
		start(r + dr[idx], c + dc[idx]);
	}

}
