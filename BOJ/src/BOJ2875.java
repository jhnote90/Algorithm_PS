import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2875 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int team;
		if (m*2 >= n) {
			team = n / 2;
			k -= m - team;
			k -= n - team*2;
		}
		else {
			team = m;
			k -= n - m*2;
		}
		if (k > 0)
			team -= (k+2)/3;
		System.out.println(team);
	}

}
