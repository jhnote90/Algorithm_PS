import java.util.Deque;
import java.util.LinkedList;

public class StockPrice {

	public static void main(String[] args) {
		int[] prices = new int[] {1, 2, 3, 2, 3};
		int n = prices.length;
		int[] answer = new int[n];
		Deque<Integer[]> deque = new LinkedList<>();
		Integer[] price;
		for (int i=0; i<n; i++) {
			while (!deque.isEmpty()) {
				price = deque.peekLast();
				if (price[0] <= prices[i])
					break;
				price = deque.pollLast();
				answer[price[1]] = i - price[1];
			}
			deque.offerLast(new Integer[] {prices[i], i});
		}
		while (!deque.isEmpty()) {
			price = deque.pollLast();
			answer[price[1]] = n - 1 - price[1];
		}
		
		for (int i=0; i<n; i++)
			System.out.println(answer[i]);
	}

}
