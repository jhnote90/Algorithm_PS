import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11653 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = (int)Math.sqrt(N);
		boolean[] isPrime = new boolean[max+1];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i=2; i*i<=max; i++) {
			if (isPrime[i]) {
				for (int j=i*i; j<=max; j+=i)
					isPrime[j] = false;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=2; i<=max; i++) {
			while (isPrime[i] && (N % i == 0)) {
				N /= i;
				sb.append(i).append('\n');
			}
			if (N == 1)
				break;
		}
		if (N != 1)
			sb.append(N).append('\n');
		System.out.print(sb);
	}

}
