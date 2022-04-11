import java.util.Arrays;
import java.util.Collections;

public class HIndex {

	public static void main(String[] args) {
		int[] citations = new int[] {3,0, 6, 1,5, 5 ,5};
		int n = citations.length;
		Integer[] cites = new Integer[n];
		for (int i=0; i<n; i++)
			cites[i] = citations[i];
		Arrays.sort(cites, Collections.reverseOrder());
		int hIndex = 0;
		for (int i=0; i<n; i++) {
			if (i+1 >= cites[i]) {
				hIndex = cites[i];
				if (i > 0) {
					for (int j=cites[i-1]-1; j>cites[i]; j--) {
						if (i >= j) {
							hIndex = j;
							break;
						}
					}
				}
				break;
			}
		}
		if (hIndex == 0) {
			for (int i=cites[n-1]-1; i>0; i--) {
				if (n >= i) {
					hIndex = i;
					break;
				}
			}
		}
		System.out.println(hIndex);
	}

}
