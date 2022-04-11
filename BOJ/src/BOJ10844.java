import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844 {

	public static void main(String[] args) throws IOException {
		int sum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] S = new int[101][10];
		for (int i=0; i<10; i++) 
			S[1][i] = 1;
		for (int i=2; i<n+1; i++) {
			for (int j=0; j<10; j++) {
				if (j==0)
					S[i][j] = S[i-1][1];
				else if (j==9)
					S[i][j] = S[i-1][8];
				else
					S[i][j] = S[i-1][j-1] + S[i-1][j+1];
				
				if (S[i][j] >= 1000000000)
					S[i][j] = S[i][j] % 1000000000;
			}
		}
		
		for (int i=1; i<10; i++) {
			sum += S[n][i];
			if (sum >= 1000000000)
				sum = sum % 1000000000;
		}
		System.out.println(sum);

	}

}
