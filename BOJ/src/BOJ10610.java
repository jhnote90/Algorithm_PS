import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = str.length();
		int[] arr = new int[n];
		int sum = 0;
		for (int i=0; i<n; i++) {
			arr[i] = str.charAt(i) - '0';
			sum += arr[i];
		}
		Arrays.sort(arr);
		if ((arr[0] != 0) || (sum%3 != 0)) {
			System.out.println(-1);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i=n-1; i>=0; i--)
			sb.append(arr[i]);
		System.out.println(sb);
	}

}
