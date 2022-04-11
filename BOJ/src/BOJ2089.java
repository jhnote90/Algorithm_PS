import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2089 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int rem;
		StringBuilder sb = new StringBuilder();
		if (n == 0) {
			System.out.println(0);
			return;
		}
		while (n != 0) {
			rem = n % (-2);
			n /= -2;
			if (rem < 0) {
				rem += 2;
				n++;
			}
			sb.append(rem);
		}
		System.out.println(sb.reverse());
	}

}
