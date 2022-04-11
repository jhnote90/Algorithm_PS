import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10992 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String star = "*";
		for (int i=0; i<N-1; i++) {
			for (int j=1; j<=N+i; j++) {
				if ((j == (N-i)) || (j == (N+i)))
					sb.append(star);
				else
					sb.append(" ");
			}
			sb.append("\n");
		}
		for (int i=0; i<(2*N-1); i++) {
			sb.append(star);
		}
		System.out.println(sb);

	}

}
