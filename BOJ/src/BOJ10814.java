import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

class Member implements Comparable<Member> {
	static int members = 1;
	int pk;
	int age;
	String name;
	
	public Member(int age, String name) {
		pk = members++;
		this.age = age;
		this.name = name;
		
	}
	
	@Override
	public int compareTo(Member o) {
		if (age == o.age)
			return pk - o.pk;
		else
			return age - o.age;
	}
	
}

public class BOJ10814 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Member[] memArr = new Member[n];
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			memArr[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(memArr);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) 
			sb.append(memArr[i].age).append(" " + memArr[i].name + "\n");
		System.out.print(sb);
		}

}
