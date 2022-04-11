import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2441 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String star = "*";
		for (int i = 0; i < N; i++) {
			for (int j=N; j>0; j--) {
				if (j <= (N-i))
					sb.append(star);
				else
					sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		

	}

}