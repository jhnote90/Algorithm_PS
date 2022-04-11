import java.util.PriorityQueue;

public class MoreSpicy {

	public static void main(String[] args) {
		int answer = 0;
		int[] scoville = new int[] {1, 2, 3, 9, 10, 12};
		int K = 7;
		int n = scoville.length;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i=0; i<n; i++)
			pq.offer(scoville[i]);
		int min1, min2;
		while (!pq.isEmpty() && pq.peek() < K) {
			min1 = pq.poll();
			if (pq.isEmpty())
				System.out.println(-1);
			min2 = pq.poll();
			pq.offer(min1 + min2 * 2);
			answer++;
		}
		System.out.println(answer);
	}

}
