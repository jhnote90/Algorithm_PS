import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int n;
		int[] S = new int[11];
		S[1] = 1; S[2] = 2; S[3] = 4;
		for (int i=4; i<11; i++) 
			S[i] = S[i-1] + S[i-2] + S[i-3];

		for (int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			System.out.println(S[n]);
		}
	}

}
