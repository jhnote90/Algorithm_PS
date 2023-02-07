import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        System.out.println(myPow(a, b, c));
    }

    public static long myPow(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }
        long num = myPow(a, b / 2, c);
        if (b % 2 == 0) {
            return (num * num) % c;
        } else {
            num = (num * num) % c;
            return (num * a) % c;
        }
    }
}
