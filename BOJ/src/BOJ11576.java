import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11576 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		int aTot = 1;
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<m-1; i++)
			aTot *= a;
		int t = 0;
		int n, rem;
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++) {
			n = Integer.parseInt(st.nextToken());
			t += n * aTot;
			aTot /= a;
		}
		if (t == 0) {
			System.out.println(0);
			return;
		}
		StringBuilder sb = new StringBuilder();
		while (t != 0) {
			rem = t % b;
			t /= b;
			list.add(rem);
		}
		for (int i=list.size()-1; i>0; i--)
			sb.append(list.get(i)).append(' ');
		sb.append(list.get(0));
		System.out.println(sb);
	}

}
