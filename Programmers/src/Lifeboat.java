import java.util.Arrays;

public class Lifeboat {

	public static void main(String[] args) {
		int[] people = new int[] {70, 80, 50};
		int limit = 100;
		Arrays.sort(people);
		int n = people.length;
		int sol = n;
		int bound = n;
		for (int i=0; i<n; i++) {
			if (bound <= i+1)
				break;
			for (int j=bound-1; j>=i+1; j--) {
				bound = j;
				if (people[i] + people[j] <= limit) {
					sol--;
					break;
				}
			}
		}
		System.out.println(sol);
	}

}
