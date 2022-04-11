import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BestAlbum {

	public static void main(String[] args) {
		int[] answer = {};
		String[] genres = new String[] {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = new int[] {500, 600, 150, 800, 2500};
		int n = genres.length;
		Map<String, Integer> genreMap = new HashMap<>();
		Map<String, Integer[]> songMap = new HashMap<>();
		for (int i=0; i<n; i++) {
			if (genreMap.containsKey(genres[i])) {
				int val = genreMap.get(genres[i]);
				genreMap.replace(genres[i], val + plays[i]);
			}
			else
				genreMap.put(genres[i], plays[i]);
			if (songMap.containsKey(genres[i])) {
				Integer[] arr = songMap.get(genres[i]);
				if (arr[1] == -1) {
					arr[1] = i;
					if (plays[arr[0]] < plays[i]) {
						arr[1] = arr[0];
						arr[0] = i;
					}
				}
				else if (plays[arr[1]] < plays[i]) {
					arr[1] = i;
					if (plays[arr[0]] < plays[i]) {
						arr[1] = arr[0];
						arr[0] = i;
					}
				}
			}
			else
				songMap.put(genres[i], new Integer[] {i, -1});
		}
		List<Entry<String, Integer>> list = new ArrayList<>(genreMap.entrySet());
		Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());
		List<Integer> bestList = new ArrayList<>();
		for (Entry<String, Integer> entry : list) {
			Integer[] arr = songMap.get(entry.getKey());
			bestList.add(arr[0]);
			if (arr[1] != -1)
				bestList.add(arr[1]);
		}
		int m = bestList.size();
		answer = new int[m];
		for (int i=0; i<m; i++)
			answer[i] = bestList.get(i);
		
		for (int i=0; i<m; i++)
			System.out.println(answer[i]);
	}

}
