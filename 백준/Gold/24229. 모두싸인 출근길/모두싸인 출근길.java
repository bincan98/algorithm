import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int[][] lst = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lst[i][0] = Integer.parseInt(st.nextToken());
            lst[i][1] = Integer.parseInt(st.nextToken());
        } // 입력완료

        Arrays.sort(lst, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        List<int[]> lstCom = new ArrayList<>();
        boolean[] visited = new boolean[N];

        // 배열 합치기
        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            int start = lst[i][0];
            int end = lst[i][1];
            for (int j = 1; j < N; j++) {
                if (i + j >= N)
                    break;
                if (lst[i + j][0] <= end) {
                    visited[i + j] = true;
                    if (end < lst[i + j][1]){
                        end = lst[i + j][1];
                    }
                } else {
                    break;
                }
            }
            lstCom.add(new int[] {start, end, end - start + end});
        } // end of for i

        int answer = lstCom.get(0)[1];
        int maxDis = lstCom.get(0)[2];
        for (int i = 1; i < lstCom.size(); i++) {
            if (lstCom.get(i)[0] <= maxDis) {
                answer = Math.max(answer, lstCom.get(i)[1]);
                maxDis = Math.max(maxDis, lstCom.get(i)[2]);
            }
        } // end of for i

        System.out.println(answer);
    } // end of main

} // end of class