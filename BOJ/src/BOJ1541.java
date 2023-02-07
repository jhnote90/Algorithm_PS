import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num;
        int plusNum = 0;
        int minusNum = 0;
        int startIdx = 0;
        int endIdx;
        char prev = '+';
        for (endIdx = 0; endIdx < str.length(); endIdx++) {
            if (str.charAt(endIdx) == '+') {
                num = Integer.parseInt(str.substring(startIdx, endIdx));
                if (prev == '+') {
                    plusNum += num;
                } else {
                    minusNum += num;
                }
                startIdx = endIdx + 1;
            } else if (str.charAt(endIdx) == '-') {
                num = Integer.parseInt(str.substring(startIdx, endIdx));
                if (prev == '+') {
                    plusNum += num;
                } else {
                    minusNum += num;
                }
                startIdx = endIdx + 1;
                prev = '-';
            }
        }
        num = Integer.parseInt(str.substring(startIdx, endIdx));
        if (prev == '+') {
            plusNum += num;
        } else {
            minusNum += num;
        }
        System.out.println(plusNum - minusNum);

    }
}
