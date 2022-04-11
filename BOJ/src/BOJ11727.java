import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11727 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] T = new int[n+1];
		T[0] = 1; T[1] = 1;
		for (int i=2; i<=n; i++) {
			T[i] = T[i-1] + 2*T[i-2];
			if (T[i]>=10007)
				T[i] = T[i]%10007;
		}
		System.out.println(T[n]);
	}
	

}
