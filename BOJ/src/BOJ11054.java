import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int temp;
		int[] A = new int[n+1];
		int[] I = new int[n+1];
		int[] D = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) 
			A[i] = Integer.parseInt(st.nextToken());
		I[1] = 1;
		for (int i=2; i<=n; i++) {
			temp = 0;
			for (int j=i-1; j>0; j--) {
				if ((A[i] > A[j]) && (I[j] > temp))
					temp = I[j];
			}
			I[i] = temp + 1;
		}
		D[n] = 1;
		for (int i=n-1; i>0; i--) {
			temp = 0;
			for (int j=i+1; j<=n; j++) {
				if ((A[i] > A[j]) && (D[j] > temp))
					temp = D[j];
			}
			D[i] = temp + 1;
		}
		int result = 0;
		for (int i=1; i<=n; i++) {
			if ((I[i] + D[i] - 1) > result)
				result = I[i] + D[i] - 1;
		}
		System.out.println(result);

	}

}
