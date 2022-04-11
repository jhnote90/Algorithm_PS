import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20055 {
	static int n;
	static int k;
	static int up;
	static int down;
	static int step;
	static int zero;
	static int[] A;
	static Queue<Integer> robots;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		A = new int[2*n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<2*n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		up = 0;
		down = n-1;
		step = 0;
		zero = 0;
		robots = new LinkedList<>();
		moveRobot();
		System.out.println(step);

	}
	
	public static void moveRobot() {
		int qSize, prev, temp, robot;
		while (zero < k) {
			step++;
			up = (up + (2*n - 1)) % (2*n);
			down = (down + (2*n - 1)) % (2*n);
			qSize = robots.size();
			prev = -1;
			for (int i=0; i<qSize; i++) {
				robot = robots.poll();
				if (robot == down)
					continue;
				temp = (robot + 1) % (2*n);
				if (temp != prev && A[temp] >= 1) {
					robot = temp;
					A[robot]--;
					if (A[robot] == 0)
						zero++;
					prev = robot;
					if (robot == down)
						continue;
					robots.offer(robot);
				}
				else {
					prev = robot;
					robots.offer(robot);
				}
			}
			if (A[up] > 0) {
				robots.offer(up);
				A[up]--;
				if (A[up] == 0)
					zero++;
			}
		}
	}

}
