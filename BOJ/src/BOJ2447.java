import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 {
	static boolean[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		star = new boolean[n+1][n+1];
		dc(1, 1, n);
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
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
			for (int i=row; i<row+size; i++) {
				for (int j=col; j<col+size; j++) {
					if (i==row+1 && j==col+1)
						continue;
					star[i][j] = true;
				}
			}
			return;
		}
		for (int i=row; i<row+size; i+=size/3) {
			for (int j=col; j<col+size; j+=size/3) {
				if (i==row+size/3 && j==col+size/3)
					continue;
				dc(i, j, size/3);
			}
		}
	}

}
