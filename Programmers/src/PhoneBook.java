import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PhoneBook {

	public static void main(String[] args) {
		String[] phone_book = new String[] {"123","456","789"};
		Arrays.sort(phone_book, (s1, s2) -> s2.length() - s1.length());
		Set<String> set = new HashSet<>();
		for (String s : phone_book) {
			if (set.contains(s)) {
				System.out.println(false);
				return;
			}
			else {
				for (int i=1; i<=s.length(); i++)
					set.add(s.substring(0, i));
			}
		}
		System.out.println(true);
	}

}
