import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {
	static int n;
	static int m;
	static int x;
	static int y;
	static int k;
	static int bot;
	static int[] cmd;
	static int[] dice;
	static int[] diceIdx;
	static int[] dr = new int[] {0, 0, 0, -1, 1};
	static int[] dc = new int[] {0, 1, -1, 0, 0};
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cmd = new int[k];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<k; i++)
			cmd[i] = Integer.parseInt(st.nextToken());
		dice = new int[7];
		bot = 1;
		diceIdx = new int[] {1, 3, 4, 2, 5, 6};
		for (int i=0; i<k; i++) {
			move(x, y, cmd[i]);
		}
	}
	
	static void move(int r, int c, int d) {
		int row = r + dr[d];
		int col = c + dc[d];
		if (row<0 || row>=n || col<0 || col>=m)
			return;
		x = row;
		y = col;
		diceIdx[0] = diceIdx[d];
		diceIdx[5] = 7 - diceIdx[0];
		switch (d) {
		case 1:
			diceIdx[2] = bot;
			diceIdx[1] = 7 - diceIdx[2];
			break;
		case 2:
			diceIdx[1] = bot;
			diceIdx[2] = 7 - diceIdx[1];
			break;
		case 3:
			diceIdx[4] = bot;
			diceIdx[3] = 7 - diceIdx[4];
			break;
		case 4:
			diceIdx[3] = bot;
			diceIdx[4] = 7 - diceIdx[3];
			break;
		}
		bot = diceIdx[0];
		if (map[x][y] == 0)
			map[x][y] = dice[bot];
		else {
			dice[bot] = map[x][y];
			map[x][y] = 0;
		}
		int top = diceIdx[5];
		System.out.println(dice[top]);
	}

}
