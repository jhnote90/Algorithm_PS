import java.util.HashMap;
import java.util.Map;

public class Camouflage {

	public static void main(String[] args) {
		int answer = 0;
		String[][] clothes = new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		Map<String, Integer> map = new HashMap<>();
		for (String[] s : clothes) {
			if (map.containsKey(s[1])) {
				int val = map.get(s[1]);
				map.replace(s[1], val+1);
			}
			else
				map.put(s[1], 1);
		}
		answer = 1;
		for (String key : map.keySet()) {
			answer *= map.get(key) + 1;
		}
		System.out.println(answer-1);
	}

}
