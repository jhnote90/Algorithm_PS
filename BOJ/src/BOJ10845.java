import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class BOJ10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				queue.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(queue.removeFirst()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				if (queue.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "front":
				if (queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(queue.getFirst()).append("\n");
				break;
			case "back":
				if (queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(queue.getLast()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}

}
