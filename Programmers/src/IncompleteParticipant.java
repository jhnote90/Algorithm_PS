import java.util.HashMap;
import java.util.Map;

public class IncompleteParticipant {

	public static void main(String[] args) {
		String answer = "";
		String[] participant = new String[] {"mislav", "stanko", "mislav", "ana"};
		String[] completion = new String[] {"stanko", "ana", "mislav"};
		Map<String, Integer> map = new HashMap<>();
		for (int i=0; i<completion.length; i++) {
			if (map.containsKey(completion[i])) {
				int val = map.get(completion[i]);
				map.replace(completion[i], val+1);
			}
			else
				map.put(completion[i], 1);
		}
		for (String s : participant) {
			if (!map.containsKey(s) || map.get(s) == 0) {
				answer = s;
				break;
			}
			else {
				int val = map.get(s);
				map.replace(s, val-1);
			}
		}
		System.out.println(answer);
	}

}
