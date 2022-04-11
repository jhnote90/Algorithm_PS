import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
	static int[][] arr;
	static int[] sol;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		sol = new int[3];
		StringTokenizer st;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		dc(1, n, 1, n);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<3; i++)
			sb.append(sol[i]).append("\n");
		System.out.println(sb);
	}
	
	public static void dc(int rowS, int rowE, int colS, int colE) {
		if (rowS == rowE) {
			sol[arr[rowS][colS]+1]++;
			return;
		}
		boolean cut = false;
		for (int i=rowS; i<=rowE; i++) {
			for (int j=colS; j<=colE; j++) {
				if (arr[i][j] != arr[rowS][colS])
					cut = true;
			}
		}
		int size = (rowE - rowS + 1) / 3;
		if (cut) {
			for (int i=rowS; i<=rowE; i+=size) {
				for (int j=colS; j<=colE; j+=size)
					dc(i, i+size-1, j, j+size-1);
			}
		}
		else
			sol[arr[rowS][colS]+1]++;
	}

}
