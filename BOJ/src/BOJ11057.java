import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11057 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] A = new int[n+1][10];
		for (int i=0; i<10; i++)
			A[1][i] = 1;
		
		for (int i=2; i<n+1; i++) {
			for (int j=0; j<10; j++) {
				A[i][j] = 0;
				for (int k=j; k<10; k++) {
					A[i][j] += A[i-1][k];
				}
				if (A[i][j] >= 10007)
					A[i][j] = A[i][j] % 10007;
			}
		}
		int result = 0;
		for (int i=0; i<10; i++)
			result += A[n][i];
		System.out.println(result%10007);

	}

}
