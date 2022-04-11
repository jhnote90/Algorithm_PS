import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ9012 {
	private static String isVPS(String str) {
		int a = 0;
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == '(') 
				a++;
			else 
				a--;
			if (a < 0)
				return "NO";
		}
		if (a != 0)
			return "NO";
		return "YES";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			sb.append(isVPS(br.readLine())).append("\n");
		}
		System.out.println(sb);
	}

}
