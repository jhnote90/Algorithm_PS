import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = str.length();
		int bars = 0;
		int result = 0;
		char c;
		char prev = '(';
		for (int i=1; i<n; i++) {
			c = str.charAt(i);
			if (c == '(') {
				if (prev == '(') {
					bars++;
					result++;
				}
				prev = '(';
			}
			else {
				if (prev == '(')
					result += bars;
				else
					bars--;
				prev = ')';
			}
		}
		System.out.println(result);
	}

}
