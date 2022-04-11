import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1850 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long gcd = a>b ? GCD(a, b) : GCD(b, a);
		StringBuilder sb = new StringBuilder();
		for (long i=1L; i<=gcd; i++)
			sb.append(1);
		System.out.println(sb);
	}

	public static long GCD(long a, long b) {
		if (b == 0L)
			return a;
		return GCD(b, a%b);
	}
}
