import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int result = 1;
		int earth, sun, moon;
		while (true) {
			if (result%15 == 0)
				earth = 15;
			else
				earth = result % 15;
			if (result%28 == 0)
				sun = 28;
			else
				sun = result % 28;
			if (result%19 == 0)
				moon = 19;
			else
				moon = result % 19;
			if ((earth == e) && (sun == s) && (moon == m))
				break;
			result++;
		}
		System.out.println(result);
	}

}
