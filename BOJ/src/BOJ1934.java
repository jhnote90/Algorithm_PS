import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1934 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int a, b, gcd;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			gcd = a>b ? GCD(a, b) : GCD(b, a);
			sb.append(a*b/gcd).append("\n");
		}
		System.out.println(sb);
	}

	public static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a%b);
	}
}
