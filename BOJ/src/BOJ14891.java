import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14891 {
	static int[] gIndex;
	static int[][] gears;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gears = new int[5][8];
		String s;
		for (int i=1; i<=4; i++) {
			s = br.readLine();
			for (int j=0; j<8; j++)
				gears[i][j] = s.charAt(j) - '0';
		}
		gIndex = new int[5];
		visited = new boolean[5];
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i=0; i<k; i++) {
			Arrays.fill(visited, false);
			st = new StringTokenizer(br.readLine());
			rotate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int score = 0;
		if (gears[1][gIndex[1]] == 1)
			score += 1;
		if (gears[2][gIndex[2]] == 1)
			score += 2;
		if (gears[3][gIndex[3]] == 1)
			score += 4;
		if (gears[4][gIndex[4]] == 1)
			score += 8;
		System.out.println(score);
		
	}
	
	public static void rotate(int n, int direction) {
		int idx1, idx2;
		visited[n] = true;
		if (n==1) {
			idx1 = (gIndex[1] + 2) % 8;
			idx2 = (gIndex[2] + 6) % 8;
			if (!visited[2] && (gears[1][idx1] != gears[2][idx2]))
				rotate(2, direction*(-1));
		}
		else if (n==4) {
			idx1 = (gIndex[4] + 6) % 8;
			idx2 = (gIndex[3] + 2) % 8;
			if (!visited[3] && (gears[4][idx1] != gears[3][idx2]))
				rotate(3, direction*(-1));
		}
		else {
			idx1 = (gIndex[n] + 6) % 8;
			idx2 = (gIndex[n-1] + 2) % 8;
			if (!visited[n-1] && (gears[n][idx1] != gears[n-1][idx2]))
				rotate(n-1, direction*(-1));
			idx1 = (gIndex[n] + 2) % 8;
			idx2 = (gIndex[n+1] + 6) % 8;
			if (!visited[n+1] && (gears[n][idx1] != gears[n+1][idx2]))
				rotate(n+1, direction*(-1));
		}
		if (direction == 1)
			gIndex[n] = (gIndex[n] + 7) % 8;
		else if (direction == -1)
			gIndex[n] = (gIndex[n] + 1) % 8;
	}

}
