import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1978 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isPrime = new boolean[1001];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i=2; i*i <= 1000; i++) {
			if (isPrime[i]) {
				for (int j=2*i; j<=1000; j+=i)
					isPrime[j] = false;
			}
		}
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (n-- > 0) {
			if (isPrime[Integer.parseInt(st.nextToken())])
				result++;
		}
		System.out.println(result);

	}

}
