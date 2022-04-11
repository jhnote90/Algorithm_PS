import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockTest {

	public static void main(String[] args) {
		int[] answers = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int n = answers.length;
		int[] ans1 = new int[] {1, 2, 3, 4, 5};
		int[] ans2 = new int[] {2,1,2,3,2,4,2,5};
		int[] ans3 = new int[] {3,3,1,1,2,2,4,4,5,5};
		int[] scores = new int[] {0, 0, 0};
		for (int i=0; i<n; i++) {
			if (ans1[i%5] == answers[i])
				scores[0]++;
			if (ans2[i%8] == answers[i])
				scores[1]++;
			if (ans3[i%10] == answers[i])
				scores[2]++;
		}
		int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<3; i++) {
			if (max == scores[i])
				list.add(i+1);
		}
		int[] answer = new int[list.size()];
		for (int i=0; i<list.size(); i++)
			answer[i] = list.get(i);
		
		for (int i=0; i<answer.length; i++)
			System.out.println(answer[i]);
		
	}

}
