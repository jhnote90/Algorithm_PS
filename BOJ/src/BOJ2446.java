import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2446 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String star = "*";
		for (int i = 1; i < 2*N; i++) {
			for (int j=1; j<2*N; j++) {
				if (i <= N) {
					if ( (i <= j) && (j <= (2*N-i)))
						sb.append(star);
					else if (i > j)
						sb.append(" ");
					else
						break;
				}
				else {
					if ( ((2*N-i) <= j) && (j <= i))
						sb.append(star);
					else if ((2*N-i) > j)
						sb.append(" ");
					else 
						break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		

	}

}