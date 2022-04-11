import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
	static int n;
	static int m;
	static int[] card;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		card = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) 
			card[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(card);
		m = Integer.parseInt(br.readLine());
		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<m; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<m; i++)
			sb.append(binarySearch(arr[i])).append(' ');
		System.out.println(sb);
	}

	private static int binarySearch(int target) {
		int start = 0;
		int mid;
		int end = n-1;
		while (start <= end) {
			mid = (start+end)/2;
			if (target == card[mid])
				return 1;
			else if (target < card[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return 0;
	}

}
