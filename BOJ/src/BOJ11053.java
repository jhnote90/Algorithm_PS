import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int temp;
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n+1];
		int[] S = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++)
			A[i] = Integer.parseInt(st.nextToken());
		S[1] = 1;
		for (int i=2; i<=n; i++) {
			temp = 0;
			for (int j=i-1; j>0; j--) {
				if ((A[i] > A[j]) && (S[j] > temp))
					temp = S[j];
			}
			S[i] = temp + 1;
		}
		int result = 0;
		for (int i=1; i<=n; i++) {
			if (S[i] > result)
				result = S[i];
		}
		System.out.println(result);
	}

}
