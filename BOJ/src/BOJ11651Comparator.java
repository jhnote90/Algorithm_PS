import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ11651Comparator {
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Point[] points = new Point[n];
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(BOJ11651Comparator.Point o1, BOJ11651Comparator.Point o2) {
				if (o1.y == o2.y)
					return o1.x - o2.x;
				else
					return o1.y - o2.y;
			}			
		});
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) {
			sb.append(points[i].x).append(' ');
			sb.append(points[i].y).append("\n");
		}
		System.out.print(sb);
	}

}
