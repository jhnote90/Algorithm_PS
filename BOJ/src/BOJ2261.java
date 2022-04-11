import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2261 {
	static int n;
	static List<Point> pList;
	static List<Point> candList;
	static YComparator yComparator;
	
	static class Point implements Comparable<Point> {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (x == o.x)
				return y - o.y;
			return x - o.x;
		}
		
	}
	
	static class YComparator implements Comparator<Point> {

		@Override
		public int compare(Point p1, Point p2) {
			if (p1.y == p2.y)
				return p1.x - p2.x;
			return p1.y - p2.y;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pList = new ArrayList<>();
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			pList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(pList);
		yComparator = new YComparator();
		System.out.println(getClosestDist(0, n-1));
	}
	
	public static int getDist(Point p1, Point p2) {
		int x = (p1.x - p2.x) * (p1.x - p2.x);
		int y = (p1.y - p2.y) * (p1.y - p2.y);
		return x+y;
	}

	public static int getClosestDist(int start, int end) {
		int dist = 2100000000;
		if (end - start < 3) {
			for (int i=start; i<end; i++) {
				for (int j=i+1; j<=end; j++) {
					dist = Math.min(dist, getDist(pList.get(i), pList.get(j)));
				}
			}
			return dist;
		}
		int mid = (start+end)/2;
		dist = Math.min(dist, getClosestDist(start, mid));
		dist = Math.min(dist,  getClosestDist(mid+1, end));
		return merge(start, mid, end, dist);
	}
	
	public static int merge(int start, int mid, int end, int dist) {
		candList = new ArrayList<>();
		int temp;
		for (int i=mid; i>=start; i--) {
			temp = pList.get(mid+1).x - pList.get(i).x;
			if (dist <= temp*temp)
				break;
			candList.add(pList.get(i));
		}
		for (int i=mid+1; i<=end; i++) {
			temp = pList.get(i).x - pList.get(mid).x;
			if (temp*temp >= dist)
				break;
			candList.add(pList.get(i));
		}
		Collections.sort(candList, yComparator);
		int size = candList.size();
		for (int i=0; i<size; i++) {
			for (int j=i+1; j<size; j++) {
				temp = candList.get(j).y - candList.get(i).y;
				if (temp*temp >= dist)
					break;
				dist = Math.min(dist, getDist(candList.get(i), candList.get(j)));
			}
		}
		return dist;
	}

}
