import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1373 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String b = br.readLine();
		int t;
		int n;
		StringBuilder sb = new StringBuilder();
		for (int i=b.length()-1; i>=0; i-=3) {
			t = 1;
			n = 0;
			for (int j=i; j>=i-2; j--) {
				if (j < 0)
					break;
				n += t * (b.charAt(j) - '0');
				t *= 2;
			}
			sb.append(n);
		}
		System.out.println(sb.reverse());
	}

}
