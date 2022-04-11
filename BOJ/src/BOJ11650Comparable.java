import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point o) {
		if (x == o.getX())
			return y - o.getY();
		else
			return x - o.getX();
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}

public class BOJ11650Comparable {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Point> pointList = new ArrayList<>();
		StringTokenizer st;
		Point point;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			pointList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(pointList);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) {
			point = pointList.get(i);
			sb.append(point.getX() + " " + point.getY()).append("\n");
		}
		System.out.print(sb);
	}

}

