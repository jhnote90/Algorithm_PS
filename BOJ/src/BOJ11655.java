import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		char c;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<S.length(); i++) {
			c = S.charAt(i);
			if ((65 <= c) && (c <= 77))
				sb.append((char)(c+13));
			else if ((77 < c) && (c <= 90))
				sb.append((char)(c+13-90+64));
			else if ((97 <= c) && (c <= 109))
				sb.append((char)(c+13));
			else if ((109 < c) && (c <= 122))
				sb.append((char)(c+13-122+96));
			else
				sb.append(c);
		}
		System.out.println(sb);
	}

}
