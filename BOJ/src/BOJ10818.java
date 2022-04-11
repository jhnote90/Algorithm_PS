import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10818 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> intList = new ArrayList<>(n);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			intList.add(Integer.parseInt(st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		sb.append(Collections.min(intList) + " ").append(Collections.max(intList));
		System.out.println(sb);
	}

}
