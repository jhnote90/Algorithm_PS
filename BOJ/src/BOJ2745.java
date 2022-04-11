import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2745 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		int t = 1;
		int result = 0;
		char c;
		for (int i=n.length()-1; i>=0; i--) {
			c = n.charAt(i);
			if (('0' <= c) && (c <= '9'))
				result += t * (c - '0');
			else
				result += t * (c - 55);
			t *= b;
		}
		System.out.println(result);
	}

}
