import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int idx = k-1;
		List<Integer> arrList = new ArrayList<>();
		for (int i=1; i<=n; i++) 
			arrList.add(i);
		int size = n;
		StringBuilder sb = new StringBuilder();
		sb.append('<').append(arrList.remove(idx));
		size--;
		for (int i=1; i<n; i++) {
			sb.append(", ");
			idx = idx + k - 1;
			if (idx >= size)
				idx = idx % size;
			sb.append(arrList.remove(idx));
			size--;
		}
		sb.append('>');
		System.out.println(sb);
	}

}
