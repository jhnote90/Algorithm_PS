import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11005 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int rem;
		StringBuilder sb = new StringBuilder();
		while (n >= b) {
			rem = n % b;
			if (rem < 10)
				sb.append(rem);
			else
				sb.append((char)(rem+55));
			n /= b;
		}
		if (n < 10)
			sb.append(n);
		else
			sb.append((char)(n+55));
		System.out.println(sb.reverse());
	}

}
