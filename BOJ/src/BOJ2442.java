import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2442 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String star = "*";
		for (int i = 0; i < N; i++) {
			for (int j=1; j<=(2*N-1); j++) {
				if ( ((N-i) <= j) && (j <= (N+i)) )
					sb.append(star);
				else if ((N-i) > j)
					sb.append(" ");
				else
					break;
			}
			sb.append("\n");
		}
		System.out.println(sb);
		

	}

}