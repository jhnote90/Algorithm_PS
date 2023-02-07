import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1339 {

    static int n;
    static String[] words;
    static Character[] arr;
    static Map<Character, Integer> map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        words = new String[n];
        map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            StringBuilder sb = new StringBuilder(words[i]);
            String str = sb.reverse().toString();
            int digit = 1;
            for (int j = 0; j < str.length(); j++) {
                if (!map.containsKey(str.charAt(j))) {
                    map.put(str.charAt(j), digit);
                } else {
                    map.replace(str.charAt(j), map.get(str.charAt(j)) + digit);
                }
                digit *= 10;
            }
        }
        arr = map.keySet().toArray(new Character[0]);
        Arrays.sort(arr, (o1, o2) -> map.get(o2) - map.get(o1));
        for (int i = 0; i < arr.length; i++) {
            num += (9 - i) * map.get(arr[i]);
        }
        System.out.println(num);
    }
}
