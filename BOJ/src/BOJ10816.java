import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ10816 {
	static int n;
	static int m;
	static Map<Integer, Integer> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		int card;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			card = Integer.parseInt(st.nextToken());
			if (map.containsKey(card))
				map.put(card, map.get(card)+1);
			else
				map.put(card, 1);
		}
		m = Integer.parseInt(br.readLine());
		int[] target = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++)
			target[i] = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<m; i++) {
			if (map.containsKey(target[i]))
				sb.append(map.get(target[i])).append(' ');
			else
				sb.append("0 ");
		}
		System.out.println(sb);
	}

}
