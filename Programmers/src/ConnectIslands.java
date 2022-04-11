import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ConnectIslands {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] costs = new int[][] {{0, 1, 1}, {0, 2, 2}, {1, 2, 5},
			{1, 3, 1}, {2, 3, 8}};
		int[][] arr = new int[n][n];
		for (int i=0; i<costs.length; i++) {
			arr[costs[i][0]][costs[i][1]] = costs[i][2];
			arr[costs[i][1]][costs[i][0]] = costs[i][2];
		}
		int size = 1;
		int optCost = 0;
		int minV, minDist;
		int[] distance = new int[n];
		Set<Integer> set = new HashSet<>();
		for (int i=1; i<n; i++) {
			set.add(i);
			distance[i] = arr[0][i];
		}
		while (size != n) {
			minDist = 0;
			minV = 0;
			for (int i : set) {
				if (distance[i] == 0)
					continue;
				if (distance[i] < minDist || minDist == 0) {
					minDist = distance[i];
					minV = i;
				}
			}
			optCost += minDist;
			set.remove(minV);
			size++;
			for (int i : set) {
				if (arr[minV][i] == 0)
					continue;
				if (arr[minV][i] < distance[i] || distance[i] == 0)
					distance[i] = arr[minV][i];
			}
		}
		System.out.println(optCost);
	}

}
