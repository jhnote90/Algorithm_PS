import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		String str;
		for (int i=1; i<=n; i++) {
			str = br.readLine();	
			for (int j=1; j<=n; j++) {
				arr[i][j] = str.charAt(j-1) - '0';
			}
		}
		sb = new StringBuilder();
		quadTree(1, n, 1, n, n);
		System.out.println(sb);
	}
	
	public static void quadTree(int rs, int re, int cs, int ce, int size) {
		boolean divide = false;
		for (int i=rs; i<=re; i++) {
			for (int j=cs; j<=ce; j++) {
				if (arr[rs][cs] != arr[i][j]) {
					divide = true;
					break;
				}
			}
		}
		if (!divide) {
			sb.append(arr[rs][cs]);
			return;
		}
		sb.append('(');
		for (int i=rs; i<=re; i+=size/2) {
			for (int j=cs; j<=ce; j+=size/2) {
				quadTree(i, i+size/2-1, j, j+size/2-1, size/2);
			}
		}
		sb.append(')');
	}

}
