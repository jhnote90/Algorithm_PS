
public class TargetNumber {
	static int[] numbers;
	static int n;
	static int cnt;

	public static void main(String[] args) {
		numbers = new int[] {1, 1, 1, 1, 1};
		n = numbers.length;
		int target = 3;
		cnt = 0;
		dfs(0, 0, target);
		System.out.println(cnt);
	}
	
	public static void dfs(int depth, int sum, int target) {
		if (depth == n) {
			if (sum == target)
				cnt++;
			return;
		}
		dfs(depth + 1, sum - numbers[depth], target);
		dfs(depth + 1, sum + numbers[depth], target);
	}

}
