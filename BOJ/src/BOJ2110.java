import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
	static int n;
	static int c;
	static int[] point;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		point = new int[n];
		for (int i=0; i<n; i++)
			point[i] = Integer.parseInt(br.readLine());
		Arrays.sort(point);
		System.out.println(binarySearch(1, point[n-1] - point[0]));
		
	}

	private static int binarySearch(int start, int end) {
		int maxDist = 0;
		int mid, cnt, bound;
		while (start <= end) {
			mid = (start+end)/2;
			cnt = 1;
			bound = point[0] + mid;
			for (int i=1; i<n; i++) {
				if (point[i] >= bound) {
					cnt++;
					bound = point[i] + mid;
				}
			}
			if (cnt >= c) {
				maxDist = mid;
				start = mid+1;
			}
			else
				end = mid-1;
		}
		return maxDist;
	}

}
