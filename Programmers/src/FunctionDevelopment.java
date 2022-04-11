import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {

	public static void main(String[] args) {
		int[] progresses = new int[] {95, 90, 99, 99, 80, 99};
		int[] speeds = new int[] {1, 1, 1, 1, 1, 1};
		int n = progresses.length;
		Queue<Integer> progQueue = new LinkedList<>();
		Queue<Integer> speedQueue = new LinkedList<>();
		for (int i=0; i<n; i++) {
			progQueue.offer(progresses[i]);
			speedQueue.offer(speeds[i]);
		}
		List<Integer> list = new ArrayList<>();
		int size, prog, speed, cnt;
		while (!progQueue.isEmpty()) {
			size = progQueue.size();
			while (size-- > 0) {
				prog = progQueue.poll();
				speed = speedQueue.poll();
				progQueue.offer(prog + speed);
				speedQueue.offer(speed);
			}
			cnt = 0;
			while (!progQueue.isEmpty() && progQueue.peek() >= 100) {
				prog = progQueue.poll();
				speed = speedQueue.poll();
				cnt++;
			}
			if (cnt > 0)
				list.add(cnt);
		}
		int m = list.size();
		int[] answer = new int[m];
		for (int i=0; i<m; i++)
			answer[i] = list.get(i);
		
		for (int i=0; i<m; i++)
			System.out.println(answer[i]);

	}

}
