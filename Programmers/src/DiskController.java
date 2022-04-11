import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {

	public static void main(String[] args) {
		int answer = 0;
		int[][] jobs = new int[][] {{0, 3}, {1, 9}, {2, 6}};
		int n = jobs.length;
		Integer[][] job = new Integer[n][];
		for (int i=0; i<n; i++)
			job[i] = new Integer[] {jobs[i][0], jobs[i][1]};
		Arrays.sort(job, (j1, j2) -> j1[0] - j2[0]);
		int time = 0;
		PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[1] - o2[1];
			}
		});
		int idx = 0;
		while (idx < n) {
			while (idx < n && job[idx][0] <= time) {
				pq.offer(job[idx++]);
			}
			if (pq.isEmpty())
				time = job[idx][0];
			else {
				Integer[] temp = pq.poll();
				time += temp[1];
				answer += time - temp[0];
			}
		}
		while (!pq.isEmpty()) {
			Integer[] temp = pq.poll();
			time += temp[1];
			answer += time - temp[0];
		}
		System.out.println(answer / n);
	}

}
