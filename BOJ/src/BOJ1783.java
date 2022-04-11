import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1783 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int visit;
		if (n == 1) {
			System.out.println(1);
			return;
		}
		if (n == 2) {
			visit = (m+1)/2;
			if (visit > 4)
				visit = 4;
			System.out.println(visit);
			return;
		}
		if (m <= 4)
			visit = m;
		else if (m >= 7)
			visit = m-2;
		else
			visit = 4;
		System.out.println(visit);
	}

}
