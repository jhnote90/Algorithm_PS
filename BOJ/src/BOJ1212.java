import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String o = br.readLine();
		StringBuilder sb = new StringBuilder();
		int n, start;
		if (o.equals("0")) {
			System.out.println(0);
			return;
		}
		for (int i=0; i<o.length(); i++) {
			n = o.charAt(i) - '0';
			if (n >= 4) {
				n -= 4;
				sb.append(1);
			}
			else
				sb.append(0);
			if (n >= 2) {
				n -= 2;
				sb.append(1);
			}
			else
				sb.append(0);
			if (n >= 1) {
				n -= 1;
				sb.append(1);
			}
			else sb.append(0);
		}
		for (start=0; start<o.length(); start++) {
			if (sb.charAt(start) == '1')
				break;
		}
		System.out.println(sb.substring(start));
	}

}
