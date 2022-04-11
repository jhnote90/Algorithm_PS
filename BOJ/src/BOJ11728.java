import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] A = new int[n];
		int[] B = new int[m];
		int[] S = new int[n+m];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			A[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++)
			B[i] = Integer.parseInt(st.nextToken());
		int i = 0;
		int j = 0;
		int k = 0;
		while ((i<n) && (j<m)) {
			if (A[i] <= B[j])
				S[k++] = A[i++];
			else
				S[k++] = B[j++];
		}
		if (i >= n) {
			while (j<m)
				S[k++] = B[j++];
		}
		else {
			while (i<n)
				S[k++] = A[i++];
		}
		StringBuilder sb = new StringBuilder();
		for (i=0; i<n+m; i++)
			sb.append(S[i]).append(' ');
		System.out.println(sb);
	}

}
