import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int minLen = n+1;
		int sum = 0;
		int start = 0;
		int end = 0;
		while (start < n) {
			if (sum < s) {
				if (end >= n)
					break;
				if (end-start < minLen-1)
					sum += arr[end++];
				else
					sum -= arr[start++];
			}
			else {
				minLen = end - start;
				if (minLen == 1)
					break;
				sum -= arr[start++];
			}
		}
		if (minLen <= n)
			System.out.println(minLen);
		else
			System.out.println(0);
	}

}
