import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

	public static void main(String[] args) {
		int[] priorities = new int[] {1, 1, 9, 1, 1, 1};
		int location = 0;
		int n = priorities.length;
		Queue<Integer[]> q = new LinkedList<>();
		for (int i=0; i<n; i++)
			q.offer(new Integer[] {priorities[i], i});
		Arrays.sort(priorities);
		int print = 0;
		Integer[] doc;
		while (!q.isEmpty()) {
			doc = q.poll();
			if (doc[0] < priorities[n-1-print])
				q.offer(doc);
			else {
				print++;
				if (doc[1] == location)
					break;
			}
		}
		System.out.println(print);
	}

}
