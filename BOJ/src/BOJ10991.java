import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BOJ10991 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		List<Integer> addList = new LinkedList<>();
		List<Integer> removeList = new LinkedList<>();
		set.add(N);
		String star = "*";
		for (int i=0; i<N; i++) {
			for (int j=1; j<=(2*N-1); j++) {
				if (set.contains(j))
					sb.append(star);
				else if (j < Collections.max(set))
					sb.append(" ");
				else
					break;
			}
			for (Integer j : set) {
				addList.add(j-1);
				addList.add(j+1);
				removeList.add(j);
			}
			set.addAll(addList);
			set.removeAll(removeList);
			addList.clear();
			removeList.clear();
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
