import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9613 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		int n;
		long sum;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			sum = 0L;
			for (int i=0; i<n; i++)
				list.add(Integer.parseInt(st.nextToken()));
			for (int i=0; i<n-1; i++)
				for (int j=i+1; j<n; j++)
					sum += GCD(list.get(i), list.get(j));
			sb.append(sum).append("\n");
			list.clear();
		}
		System.out.print(sb);
	}

	public static int GCD(int a, int b) {
		if (b == 0L)
			return a;
		return GCD(b, a%b);
	}
}
