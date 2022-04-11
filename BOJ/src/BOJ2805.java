import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
	static int n;
	static int m;
	static int[] height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int max = 0;
		height = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			if (max < height[i])
				max = height[i];
		}
		System.out.println(binarySearch(0, max));
	}
	
	public static int binarySearch(int start, int end) {
		int mid;
		long treeLen;
		int maxHeight = 0;
		while (start <= end) {
			treeLen = 0;
			mid = (start+end) / 2;
			for (int i=0; i<n; i++) {
				if (height[i] > mid)
					treeLen += height[i] - mid;
			}
			if (treeLen >= m) {
				maxHeight = mid;
				start = mid + 1;
			}
			else
				end = mid - 1;
		}
		return maxHeight;
	}

}
