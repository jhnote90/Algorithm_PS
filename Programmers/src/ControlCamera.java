import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControlCamera {
	
	static class Car implements Comparable<Car> {
		int start;
		int end;
		
		public Car(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public int compareTo(Car o) {
			return start - o.start;
		}
		
	}

	public static void main(String[] args) {
		int[][] routes = new int[][] {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
		int answer = 0;
		int n = routes.length;
		List<Car> list = new ArrayList<>();
		for (int i=0; i<n; i++)
			list.add(new Car(routes[i][0], routes[i][1]));
		Collections.sort(list);
		int end = -30001;
		for (Car car : list) {
			if (car.start > end) {
				answer++;
				end = car.end;
				continue;
			}
			if (car.end < end)
				end = car.end;
		}
		System.out.println(answer);
	}

}
