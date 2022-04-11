import java.util.LinkedList;
import java.util.Queue;

public class Truck {

	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = new int[] {10,10,10,10,10,10,10,10,10,10};
		int n = truck_weights.length;
		int second = 0;
		int idx = 0;
		Queue<Integer[]> q = new LinkedList<>();
		second++;
		weight -= truck_weights[idx];
		q.offer(new Integer[] {truck_weights[idx++], 1});
		Integer[] truck;
		while (!q.isEmpty()) {
			second++;
			int size = q.size();
			while (size-- > 0) {
				truck = q.poll();
				weight += truck[0];
				truck[1]++;
				if (truck[1] <= bridge_length) {
					weight -= truck[0];
					q.offer(truck);
				}
			}
			if (idx < n && truck_weights[idx] <= weight) {
				weight -= truck_weights[idx];
				q.offer(new Integer[] {truck_weights[idx++], 1});
			}
		}
		System.out.println(second);
	}

}
