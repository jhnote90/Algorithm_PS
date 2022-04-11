import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1451 {
	static int[][] rect;
	
	static class Rectangle {
		int startRow;
		int startCol;
		int endRow;
		int endCol;
		long sum;
		
		public Rectangle (int sr, int sc, int er, int ec) {
			startRow = sr;
			startCol = sc;
			endRow = er;
			endCol = ec;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		rect = new int[n+1][m+1];
		String str;
		for (int i=1; i<=n; i++) {
			str = br.readLine();
			for (int j=1; j<=m; j++)
				rect[i][j] = str.charAt(j-1) - '0';
		}
		long sum = 0;
		long max = 0;
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=m; j++)
				sum += rect[i][j];
		}
		Rectangle r1, r2, r3;
		long temp;
		// 열로 나누기
		for (int i=1; i<=m-1; i++) {
			r1 = new Rectangle(1, 1, n, i);
			r2 = new Rectangle(1, i+1, n, m);
			r1.sum = rectSum(r1.startRow, r1.startCol, r1.endRow, r1.endCol);
			r2.sum = sum - r1.sum;
			// r1 열로 나누기
			for (int j=r1.startCol; j<=r1.endCol-1; j++) {
				r3 = new Rectangle(r1.startRow, r1.startCol, r1.endRow, j);
				r3.sum = rectSum(r3.startRow, r3.startCol, r3.endRow, r3.endCol);
				temp = (r1.sum - r3.sum) * r2.sum * r3.sum;
				if (temp > max)
					max = temp;
			}
			// r1 행으로 나누기
			for (int j=r1.startRow; j<=r1.endRow-1; j++) {
				r3 = new Rectangle(r1.startRow, r1.startCol, j, r1.endCol);
				r3.sum = rectSum(r3.startRow, r3.startCol, r3.endRow, r3.endCol);
				temp = (r1.sum - r3.sum) * r2.sum * r3.sum;
				if (temp > max)
					max = temp;
			}
			// r2 열로 나누기
			for (int j=r2.startCol; j<=r2.endCol-1; j++) {
				r3 = new Rectangle(r2.startRow, r2.startCol, r2.endRow, j);
				r3.sum = rectSum(r3.startRow, r3.startCol, r3.endRow, r3.endCol);
				temp = r1.sum * (r2.sum - r3.sum) * r3.sum;
				if (temp > max)
					max = temp;
			}
			// r2 행으로 나누기
			for (int j=r2.startRow; j<=r2.endRow-1; j++) {
				r3 = new Rectangle(r2.startRow, r2.startCol, j, r2.endCol);
				r3.sum = rectSum(r3.startRow, r3.startCol, r3.endRow, r3.endCol);
				temp = r1.sum * (r2.sum - r3.sum) * r3.sum;
				if (temp > max)
					max = temp;
			}
		}
		// 행으로 나누기
		for (int i=1; i<=n-1; i++) {
			r1 = new Rectangle(1, 1, i, m);
			r2 = new Rectangle(i+1, 1, n, m);
			r1.sum = rectSum(r1.startRow, r1.startCol, r1.endRow, r1.endCol);
			r2.sum = sum - r1.sum;
			// r1 열로 나누기
			for (int j=r1.startCol; j<=r1.endCol-1; j++) {
				r3 = new Rectangle(r1.startRow, r1.startCol, r1.endRow, j);
				r3.sum = rectSum(r3.startRow, r3.startCol, r3.endRow, r3.endCol);
				temp = (r1.sum - r3.sum) * r2.sum * r3.sum;
				if (temp > max)
					max = temp;
			}
			// r1 행으로 나누기
			for (int j=r1.startRow; j<=r1.endRow-1; j++) {
				r3 = new Rectangle(r1.startRow, r1.startCol, j, r1.endCol);
				r3.sum = rectSum(r3.startRow, r3.startCol, r3.endRow, r3.endCol);
				temp = (r1.sum - r3.sum) * r2.sum * r3.sum;
				if (temp > max)
					max = temp;
			}
			// r2 열로 나누기
			for (int j=r2.startCol; j<=r2.endCol-1; j++) {
				r3 = new Rectangle(r2.startRow, r2.startCol, r2.endRow, j);
				r3.sum = rectSum(r3.startRow, r3.startCol, r3.endRow, r3.endCol);
				temp = r1.sum * (r2.sum - r3.sum) * r3.sum;
				if (temp > max)
					max = temp;
			}
			// r2 행으로 나누기
			for (int j=r2.startRow; j<=r2.endRow-1; j++) {
				r3 = new Rectangle(r2.startRow, r2.startCol, j, r2.endCol);
				r3.sum = rectSum(r3.startRow, r3.startCol, r3.endRow, r3.endCol);
				temp = r1.sum * (r2.sum - r3.sum) * r3.sum;
				if (temp > max)
					max = temp;
			}
		}
		System.out.println(max);
	}
	
	public static long rectSum(int sr, int sc, int er, int ec) {
		long sum = 0;
		for (int i=sr; i<=er; i++) {
			for (int j=sc; j<=ec; j++)
				sum += rect[i][j];
		}
		return sum;
	}

}
