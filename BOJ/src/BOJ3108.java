import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ3108 {
	static int n;
	static boolean[] visited;
	static List<Rectangle> list;
	
	static class Rectangle {
		int x1;
		int y1;
		int x2;
		int y2;
		
		public Rectangle(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		list = new ArrayList<>();
		StringTokenizer st;
		int x1, y1, x2, y2;
		int startIdx = -1;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			list.add(new Rectangle(x1, y1, x2, y2));
			if (onRectangle(i, 0, 0))
				startIdx = i;
		}
		int PU = 0;
		if (startIdx != -1)
			dfs(startIdx);
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				PU++;
				dfs(i);
			}
		}
		System.out.println(PU);
	}
	
	public static boolean onRectangle(int idx, int x, int y) {
		Rectangle r = list.get(idx);
		if ((x == r.x1) || (x == r.x2)) {
			if ((y >= r.y1) && (y <= r.y2))
				return true;
		}
		if ((y == r.y1) || (y == r.y2)) {
			if ((x >= r.x1) && (x <= r.x2))
				return true;
		}
		return false;
	}
	
	public static boolean xOnRectangle(int idx, int x1, int x2, int y) {
		Rectangle r = list.get(idx);
		if ((y < r.y1) || (y > r.y2))
			return false;
		if ((x2 < r.x1) || (x1 > r.x2))
			return false;
		if ((y > r.y1) && (y < r.y2)) {
			if ((x1 > r.x1) && (x2 < r.x2))
				return false;
		}
		return true;
	}
	
	public static boolean yOnRectangle(int idx, int x, int y1, int y2) {
		Rectangle r = list.get(idx);
		if ((x < r.x1) || (x > r.x2))
			return false;
		if ((y2 < r.y1) || (y1 > r.y2))
			return false;
		if ((x > r.x1) && (x < r.x2)) {
			if ((y1 > r.y1) && (y2 < r.y2))
				return false;
		}
		return true;
	}
	
	public static void dfs(int idx) {
		visited[idx] = true;
		Rectangle r = list.get(idx);
		for (int i=0; i<n; i++) {
			if (visited[i])
				continue;
			if (xOnRectangle(i, r.x1, r.x2, r.y1) || xOnRectangle(i, r.x1, r.x2, r.y2) || 
					yOnRectangle(i, r.x1, r.y1, r.y2) || yOnRectangle(i, r.x2, r.y1, r.y2))
				dfs(i);
		}
	}

}
