import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {

	public static void main(String[] args) throws IOException {
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(n % k);
			n = n / k;
		}
		sb = sb.reverse();
		int start = 0;
		for (int i=0; i<sb.length(); i++) {
			if (sb.charAt(i) == '0') {
				if (start < i) {
					result += isPrime(Integer.parseInt(sb.substring(start, i)));
				}
				start = i+1;
			}
		}
		if (sb.charAt(sb.length()-1) != '0') {
			result += isPrime(Integer.parseInt(sb.substring(start, sb.length())));
		}
		System.out.println(result);

	}
	
	public static int isPrime(int n) {
		if (n < 2)
			return 0;
		for (int i=2; i*i<=n; i++) {
			if (n % i == 0)
				return 0;
		}
		return 1;
	}

}
