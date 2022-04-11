import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n+1];
		int[] S = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++)
			A[i] = Integer.parseInt(st.nextToken());
		S[1] = A[1];
		int result = S[1];
		for (int i=2; i<=n; i++) {
			if (S[i-1] > 0)
				S[i] = S[i-1] + A[i];
			else
				S[i] = A[i];
			if (S[i] > result)
				result = S[i];
		}
		System.out.println(result);
	}

}
