import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2448 {
	static boolean[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		star = new boolean[n+1][n*2];
		dc(1, n, n);
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=n; i++) {
			for (int j=1; j<n*2; j++) {
				if (star[i][j])
					sb.append('*');
				else
					sb.append(' ');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dc(int row, int col, int size) {
		if (size == 3) {
			star[row][col] = true;
			star[row+1][col-1] = true;
			star[row+1][col+1] = true;
			for (int i=col-2; i<=col+2; i++)
				star[row+2][i] = true;
			return;
		}
		dc(row, col, size/2);
		dc(row+size/2, col-size/2, size/2);
		dc(row+size/2, col+size/2, size/2);
	}
}
