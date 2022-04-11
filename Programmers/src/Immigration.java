import java.util.Arrays;

public class Immigration {
	static long answer;

	public static void main(String[] args) {
		int n = 1000000000;
		int[] times = new int[] {1000000000};
		Arrays.sort(times);
		long max = (long)n * times[0];
		System.out.println(max);
		answer = max;
		binarySearch(1, max, n, times);
		System.out.println(answer);
		

	}
	
	public static void binarySearch(long s, long e, int n, int[] times) {
		if (s > e)
			return;
		long mid = (s + e) / 2;
		long people = 0L;
		for (int i : times) {
			if (i > mid)
				break;
			people += mid / i;
		}
		if (people < n)
			binarySearch(mid+1, e, n, times);
		else {
			answer = mid;
			binarySearch(s, mid-1, n, times);
		}
	}

}
