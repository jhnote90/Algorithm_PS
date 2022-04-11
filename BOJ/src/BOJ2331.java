import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ2331 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int n = a;
		List<Integer> list = new ArrayList<>();
		TreeSet<Integer> set = new TreeSet<>();
		list.add(a);
		set.add(a);
		while (true) {
			n = D(n, p);
			if (set.contains(n)) {
				System.out.println(list.indexOf(n));
				break;
			}
			list.add(n);
			set.add(n);
		}
	}
	
	public static int D(int prev, int p) {
		String str = prev + "";
		int sum = 0;
		for (int i=0; i<str.length(); i++) 
			sum += (int)Math.pow((str.charAt(i) - '0'), p);
		return sum;
	}

}
