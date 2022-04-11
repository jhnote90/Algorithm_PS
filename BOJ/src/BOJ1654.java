import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
	static long[] lan;
	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		long max = 0L;
		lan = new long[k];
		for (int i=0; i<k; i++) {
			lan[i] = Long.parseLong(br.readLine());
			if (max < lan[i])
				max = lan[i];
		}
		System.out.println(binarySearch(1, max));
		
	}
	
	public static long binarySearch(long start, long end) {
		long mid, num;
		long maxLen = start;
		while (start <= end) {
			num = 0;
			mid = (start+end) / 2;
			for (int i=0; i<k; i++)
				num += lan[i] / mid;
			if (num >= n) {
				maxLen = mid;
				start = mid + 1;
			}
			else
				end = mid - 1;
		}
		return maxLen;
	}

}
