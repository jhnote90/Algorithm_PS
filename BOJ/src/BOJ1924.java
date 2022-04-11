import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1924 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dateDiff = 0;
		for (int i=1; i<x; i++) {
			if (i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12)
				dateDiff += 31;
			else if (i==2)
				dateDiff += 28;
			else
				dateDiff += 30;
		}
		dateDiff += y-1;
		switch (dateDiff%7) {
		case 0:
			System.out.println("MON");
			break;
		case 1:
			System.out.println("TUE");
			break;
		case 2:
			System.out.println("WED");
			break;
		case 3:
			System.out.println("THU");
			break;
		case 4:
			System.out.println("FRI");
			break;
		case 5:
			System.out.println("SAT");
			break;
		default:
			System.out.println("SUN");
			break;
		}

	}

}
