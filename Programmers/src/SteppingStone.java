import java.util.Arrays;

public class SteppingStone {
	static int[] dist;
	static int max;

	public static void main(String[] args) {
		int distance = 25;
		int[] rocks = new int[] {2, 14, 11, 21, 17};
		int n = 2;
		Arrays.sort(rocks);
		dist = new int[rocks.length+1];
		dist[0] = rocks[0];
		for (int i=1; i<rocks.length; i++)
			dist[i] = rocks[i] - rocks[i-1];
		dist[rocks.length] = distance - rocks[rocks.length-1];
		max = 0;
		binarySearch(0, distance, n);
		System.out.println(max);
	}
	
	public static void binarySearch(int s, int e, int n) {
		if (s > e)
			return;
		int mid = (s+e)/2;
		boolean possible = true;
		int size = dist.length;
		int i = 0;
		int d = dist[i++];
		int remove = 0;
		while (d < mid) {
			if (i >= size || remove >= n) {
				possible = false;
				break;
			}
			d += dist[i++];
			remove++;
		}
		while (i < size && possible) {
			d = dist[i++];
			while (d < mid) {
				if (remove >= n) {
					possible = false;
					break;
				}
				if (i == size) {
					remove++;
					break;
				}
				d += dist[i++];
				remove++;
			}
		}
		if (possible) {
			max = mid;
			binarySearch(mid+1, e, n);
		}
		else
			binarySearch(s, mid-1, n);
	}

}
