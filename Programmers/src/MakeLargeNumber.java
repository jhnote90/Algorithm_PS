import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class MakeLargeNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		int k = Integer.parseInt(br.readLine());
		int n = number.length();
		int[] arr = new int[n];
		for (int i=0; i<n; i++)
			arr[i] = number.charAt(i) - '0';
		int cnt = 0;
		LinkedList<Integer> list = new LinkedList<>();
		for (int i=0; i<n; i++) {
			while (!list.isEmpty() && cnt < k) {
				if (list.getLast() >= arr[i])
					break;
				list.removeLast();
				cnt++;
			}
			list.add(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		cnt = 0;
		for (int i : list) {
			sb.append(i);
			cnt++;
			if (cnt == n-k)
				break;
		}
		System.out.println(sb);
	}

}
