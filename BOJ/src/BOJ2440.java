import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2440 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String star = "*";
		for (int i = 1; i <= N; i++) {
			for (int j=N; j>=i; j--) {
					sb.append(star);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		

	}

}