import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ1744 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num, size;
		int sum = 0;
		List<Integer> mList = new ArrayList<>();
		List<Integer> pList = new ArrayList<>();
		for (int i=0; i<n; i++) {
			num = Integer.parseInt(br.readLine());
			if (num < 1)
				mList.add(num);
			else if (num == 1)
				sum += num;
			else
				pList.add(num);
		}
		Collections.sort(mList);
		size = mList.size();
		for (int i=0; i<size; i+=2) {
			if (i == size-1) {
				sum += mList.get(i);
				continue;
			}
			sum += mList.get(i) * mList.get(i+1);
		}
		Collections.sort(pList);
		size = pList.size();
		for (int i=size-1; i>=0; i-=2) {
			if (i == 0) {
				sum += pList.get(i);
				continue;
			}
			sum += pList.get(i) * pList.get(i-1);
		}
		System.out.println(sum);
	}
}
