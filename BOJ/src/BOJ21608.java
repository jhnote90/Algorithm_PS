import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21608 {
	static int n;
	static int max;
	static int[] dr = new int[] {-1, 0, 1, 0};
	static int[] dc = new int[] {0, 1, 0, -1};
	static int[][] student;
	static int[][] room;
	static int[][] cand;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		student = new int[n*n][5];
		room = new int[n][n];
		cand = new int[n][n];
		StringTokenizer st;
		for (int i=0; i<n*n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<5; j++)
				student[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i=0; i<n*n; i++) {
			max = -1;
			setPos(i);
		}
		int result = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				result += satisfaction(i, j);
			}
		}
		System.out.println(result);
	}
	
	public static void setPos(int num) {
		int temp;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				temp = 0;
				if (room[i][j] == 0) {
					for (int k=0; k<4; k++)
						temp += like(num, i+dr[k], j+dc[k]);
				}
				else
					temp = -1;
				cand[i][j] = temp;
				if (temp > max)
					max = temp;
			}
		}
		int m = max;
		max = -1;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				temp = 0;
				if (cand[i][j] == m) {
					for (int k=0; k<4; k++)
						temp += blank(i+dr[k], j+dc[k]);
				}
				else
					temp = -1;
				cand[i][j] = temp;
				if (temp > max)
					max = temp;
			}
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (cand[i][j] == max) {
					room[i][j] = student[num][0];
					return;
				}
			}
		}
	}

	public static int like(int num, int row, int col) {
		if (row<0 || row>=n || col<0 || col>=n)
			return 0;
		for (int i=1; i<=4; i++) {
			if (student[num][i] == room[row][col])
				return 1;
		}
		return 0;
	}
	
	public static int blank(int row, int col) {
		if (row<0 || row>=n || col<0 || col>=n)
			return 0;
		if (room[row][col] == 0)
			return 1;
		return 0;
	}
	
	public static int satisfaction(int r, int c) {
		int num = 0;
		int ret = 0;
		int s = room[r][c];
		int row, col;
		for (int i=0; i<n*n; i++) {
			if (student[i][0] == s) {
				for (int j=0; j<4; j++) {
					row = r + dr[j];
					col = c + dc[j];
					if (row<0 || row>=n || col<0 || col>=n)
						continue;
					for (int k=1; k<=4; k++) {
						if (student[i][k] == room[row][col])
							num++;
					}
				}
			}
		}
		switch (num) {
		case 1:
			ret = 1;
			break;
		case 2:
			ret = 10;
			break;
		case 3:
			ret = 100;
			break;
		case 4:
			ret = 1000;
			break;
		}
		return ret;
	}
}
