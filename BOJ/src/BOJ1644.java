import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ1644 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		for (int i=2; i*i<=n; i++) {
			if (isPrime[i]) {
				for (int j=i*i; j<=n; j+=i)
					isPrime[j] = false;
			}
		}
		List<Integer> prime = new ArrayList<>();
		for (int i=2; i<=n; i++) {
			if (isPrime[i])
				prime.add(i);
		}
		int len = prime.size();
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		while (start < len) {
			if (sum < n) {
				if (end >= len)
					break;
				sum += prime.get(end++);
			}
			else if (sum == n) {
				cnt++;
				sum -= prime.get(start++);
			}
			else
				sum -= prime.get(start++);
		}
		System.out.println(cnt);
	}

}
