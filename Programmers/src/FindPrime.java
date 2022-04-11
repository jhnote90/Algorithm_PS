import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPrime {
	static int n;
	static int[] nums;
	static int[] sol;
	static boolean[] visited;
	static boolean[] isPrime;
	static Set<Integer> primeSet;

	public static void main(String[] args) {
		String numbers = "011";
		n = numbers.length();
		nums = new int[n];
		for (int i=0; i<n; i++)
			nums[i] = numbers.charAt(i) - '0';
		visited = new boolean[n];
		int max = (int)Math.pow(10, n);
		isPrime = new boolean[max];
		Arrays.fill(isPrime, true);
		isPrime[0] = false; isPrime[1] = false;
		for (int i=2; i*i<max; i++) {
			if (isPrime[i]) {
				for (int j=i*i; j<max; j+=i)
					isPrime[j] = false;
			}
		}
		sol = new int[n];
		primeSet = new HashSet<>();
		dfs(0, sol);
		System.out.println(primeSet.size());

	}
	
	public static void dfs(int depth, int[] sol) {
		if (depth > 0) {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<depth; i++)
				sb.append(sol[i]);
			int num = Integer.parseInt(sb.toString());
			if (isPrime[num])
				primeSet.add(num);
			if (depth == n)
				return;
		}
		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sol[depth] = nums[i];
				dfs(depth+1, sol);
				visited[i] = false;
			}
		}
	}

}
