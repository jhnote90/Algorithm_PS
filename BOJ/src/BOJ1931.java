import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1931 {
	
	static class Conference implements Comparable<Conference> {
		int start;
		int end;
		
		public Conference(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Conference o) {
			if (end == o.end)
				return start - o.start;
			return end - o.end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Conference> cList = new ArrayList<>();
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			cList.add(new Conference(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(cList);
		int cnt = 0;
		int bound = 0;
		for (Conference c : cList) {
			if (c.start >= bound) {
				cnt++;
				bound = c.end;
			}
		}
		System.out.println(cnt);
	}

}
