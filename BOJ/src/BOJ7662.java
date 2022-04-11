import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int size, k;
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
		Map<Integer, Integer> minMap = new HashMap<>();
		Map<Integer, Integer> maxMap = new HashMap<>();
		StringTokenizer st;
		String op;
		int num, temp;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			size = 0;
			k = Integer.parseInt(br.readLine());
			for (int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				op = st.nextToken();
				num = Integer.parseInt(st.nextToken());
				if (op.equals("I")) {
					minPQ.offer(num);
					maxPQ.offer(num);
					size++;
				}
				else if (size > 0) {
					if (num == 1) {
						while (maxMap.containsKey(maxPQ.peek())) {
							temp = maxPQ.poll();
							if (maxMap.get(temp) > 1)
								maxMap.replace(temp, maxMap.get(temp)-1);
							else
								maxMap.remove(temp);
						}
						temp = maxPQ.poll();
						if (minMap.containsKey(temp))
							minMap.replace(temp, minMap.get(temp)+1);
						else
							minMap.put(temp, 1);
					}
					else {
						while (minMap.containsKey(minPQ.peek())) {
							temp = minPQ.poll();
							if (minMap.get(temp) > 1)
								minMap.replace(temp, minMap.get(temp)-1);
							else
								minMap.remove(temp);
						}
						temp = minPQ.poll();
						if (maxMap.containsKey(temp))
							maxMap.replace(temp, maxMap.get(temp)+1);
						else
							maxMap.put(temp, 1);
					}
					size--;
				}
			}
			if (size == 0) 
				sb.append("EMPTY").append("\n");
			else {
				while (maxMap.containsKey(maxPQ.peek())) {
					temp = maxPQ.poll();
					if (maxMap.get(temp) > 1)
						maxMap.replace(temp, maxMap.get(temp)-1);
					else
						maxMap.remove(temp);
				}
				sb.append(maxPQ.poll()).append(' ');
				while (minMap.containsKey(minPQ.peek())) {
					temp = minPQ.poll();
					if (minMap.get(temp) > 1)
						minMap.replace(temp, minMap.get(temp)-1);
					else
						minMap.remove(temp);
				}
				sb.append(minPQ.poll()).append("\n");
			}
			maxPQ.clear();
			minPQ.clear();
			maxMap.clear();
			minMap.clear();
		}
		System.out.println(sb);
	}

}
