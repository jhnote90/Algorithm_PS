import java.util.*;

public class ReportResult {

    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        Map<String, Integer> resultMail = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String s : id_list) {
            resultMail.put(s, 0);
            reportMap.put(s, new HashSet<>());
        }
        for (String s : report) {
            StringTokenizer st = new StringTokenizer(s);
            String user = st.nextToken();
            String reportedUser = st.nextToken();
            reportMap.get(reportedUser).add(user);
        }
        for (String s : id_list) {
            Set<String> userSet = reportMap.get(s);
            if (userSet.size() >= k) {
                for (String user : userSet) {
                    resultMail.replace(user, resultMail.get(user) + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            answer[i] = resultMail.get(id_list[i]);
        }
        return answer;
    }
}
