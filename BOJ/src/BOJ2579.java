import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] S = new int[n+1];
		int[] M = new int[n+1];
		for (int i=1; i<=n; i++)
			S[i] = Integer.parseInt(br.readLine());
		M[0] = 0;
		M[1] = S[1];
		if (n>1)
			M[2] = S[1] + S[2];
		for (int i=3; i<=n; i++) 
			M[i] = Math.max((S[i-1] + M[i-3]), M[i-2]) + S[i];
		System.out.println(M[n]);
	}

}
