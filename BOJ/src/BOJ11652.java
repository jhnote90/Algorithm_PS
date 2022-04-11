import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BOJ11652 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Long, Integer> map = new HashMap<>();
		long num, entryKey;
		for (int i=0; i<n; i++) {
			num = Long.parseLong(br.readLine());
			if (map.containsKey(num)) 
				map.put(num, map.get(num)+1);
			else
				map.put(num, 1);
		}
		int entryValue;
		int maxValue = 0;
		long result = 0;
		for (Entry<Long, Integer> entry : map.entrySet()) {
			entryKey = entry.getKey();
			entryValue = entry.getValue();
			if (entryValue > maxValue) {
				maxValue = entryValue;
				result = entryKey;
			}
			else if ((entryValue == maxValue) && (entryKey < result))
				result = entryKey;
		}
		System.out.println(result);
	}

}
