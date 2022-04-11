import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10825 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Student[] students = new Student[n];
		StringTokenizer st;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(students);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++)
			sb.append(students[i].name).append("\n");
		System.out.print(sb);
	}

}

class Student implements Comparable<Student> {
	String name;
	int korean;
	int english;
	int math;
	
	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	@Override
	public int compareTo(Student o) {
		if (korean != o.korean)
			return o.korean - korean;
		else if (english != o.english)
			return english - o.english;
		else if (math != o.math)
			return o.math - math;
		else
			return name.compareTo(o.name);
	}
	
}