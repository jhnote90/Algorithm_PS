import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {

	public static void main(String[] args) {
		int[] numbers = new int[] {40, 404};
		int n = numbers.length;
		String[] nums = new String[n];
		for (int i=0; i<n; i++)
			nums[i] = numbers[i] + "";
		Arrays.sort(nums, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				int n1 = Integer.parseInt(s1+s2);
				int n2 = Integer.parseInt(s2+s1);
				return n2 - n1;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++)
			sb.append(nums[i]);
		System.out.println(sb.toString());

	}

}
