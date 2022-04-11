import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int gcd = a>b ? GCD(a, b) : GCD(b, a);
		int lcm = gcd * (a/gcd) * (b/gcd);
		System.out.println(gcd);
		System.out.println(lcm);
	}

	public static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a%b);
	}
}
