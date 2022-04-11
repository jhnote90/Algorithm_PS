import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DoublyPriorityQueue {

	public static void main(String[] args) {
		String[] operations = new String[] {"I 3","D -1","I 1","I 2"};
		int size = 0;
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>((i1, i2) -> i2 - i1);
		Map<Integer, Integer> minMap = new HashMap<>();
		Map<Integer, Integer> maxMap = new HashMap<>();
		StringTokenizer st;
		String op;
		int num, temp;		
		for (int i=0; i<operations.length; i++) {
			st = new StringTokenizer(operations[i]);
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
		int max, min;
		if (size == 0) {
			max = 0;
			min = 0;
		}
		else {
			while (maxMap.containsKey(maxPQ.peek())) {
				temp = maxPQ.poll();
				if (maxMap.get(temp) > 1)
					maxMap.replace(temp, maxMap.get(temp)-1);
				else
					maxMap.remove(temp);
			}
			max = maxPQ.poll();
			while (minMap.containsKey(minPQ.peek())) {
				temp = minPQ.poll();
				if (minMap.get(temp) > 1)
					minMap.replace(temp, minMap.get(temp)-1);
				else
					minMap.remove(temp);
			}
			min = minPQ.poll();
		}
		System.out.println(max);
		System.out.println(min);
	}

}
