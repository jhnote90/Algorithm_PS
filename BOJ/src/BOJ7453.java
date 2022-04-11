import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7453 {
	static int n;
	static long cnt;
	static int[] sumAB;
	static int[] sumCD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		sumAB = new int[n*n];
		sumCD = new int[n*n];
		int k = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				sumAB[k] = a[i] + b[j];
				sumCD[k] = c[i] + d[j];
				k++;
			}
		}
		Arrays.sort(sumAB);
		Arrays.sort(sumCD);
		cnt = 0L;
		binarySearch(0, n*n-1, sumAB[0]);
		long prev = cnt;
		for (int i=1; i<n*n; i++) {
			if (sumAB[i] == sumAB[i-1]) {
				cnt += prev;
				continue;
			}
			prev = cnt;
			binarySearch(0, n*n-1, sumAB[i]);
			prev = cnt - prev;
		}
		System.out.println(cnt);
	}
	
	public static void binarySearch(int start, int end, int sum) {
		if (start > end)
			return;
		if ((sumCD[start]+sum > 0) || (sumCD[end]+sum < 0))
			return;
		if ((sumCD[start]+sum == 0) && (sumCD[end]+sum == 0)) {
			cnt += end - start + 1;
			return;
		}
		int mid = (start+end) / 2;
		if (sumCD[mid] + sum < 0)
			binarySearch(mid+1, end, sum);
		else if (sumCD[mid] + sum == 0) {
			cnt++;
			binarySearch(start, mid-1, sum);
			binarySearch(mid+1, end, sum);
		}
		else
			binarySearch(start, mid-1, sum);
	}

}
