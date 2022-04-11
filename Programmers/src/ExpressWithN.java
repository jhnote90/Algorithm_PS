import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressWithN {
	static List<List<Integer>> list;
	static Set<Integer> set;

	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		list = new ArrayList<>();
		set = new HashSet<>();
		for (int i=0; i<9; i++)
			list.add(new ArrayList<>());
		list.get(1).add(N);
		set.add(N);
		if (number == N) {
			System.out.println(1);
			return;
		}
		List<Integer> optList1, optList2;
		StringBuilder sb;
		for (int i=2; i<9; i++) {
			sb = new StringBuilder();
			for (int j=0; j<i; j++)
				sb.append(N);
			int num = Integer.parseInt(sb.toString());
			if (!set.contains(num)) {
				list.get(i).add(num);
				set.add(num);
			}
			for (int j=1; j<=i/2; j++) {
				optList1 = list.get(j);
				optList2 = list.get(i-j);
				for (int k : optList1) {
					for (int l : optList2) {
						if (k > l)
							operation(k, l, i);
						else
							operation(l, k, i);
					}
				}
			}
			if (set.contains(number)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
	
	public static void operation(int opt1, int opt2, int idx) {
		if (!set.contains(opt1+opt2)) {
			list.get(idx).add(opt1+opt2);
			set.add(opt1+opt2);
		}
		if (opt1 - opt2 != 0 && !set.contains(opt1-opt2)) {
			list.get(idx).add(opt1-opt2);
			set.add(opt1-opt2);
		}
		if (!set.contains(opt1/opt2)) {
			list.get(idx).add(opt1/opt2);
			set.add(opt1/opt2);
		}
		if (!set.contains(opt1*opt2)) {
			list.get(idx).add(opt1*opt2);
			set.add(opt1*opt2);
		}
	}

}
