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
        int answer = 100_000_000;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                List<Integer> can = new ArrayList<>();
                for (int k = 0; k < N; k++) {
                    if (lst[i][0] <= lst[k][0] && lst[k][0] <= lst[j][0]) {
                        can.add(lst[k][1]);
                    }
                }
                if (can.size() < N / 2)
                    continue;
                Collections.sort(can);
                for (int k = 0; k < can.size() - (int) (N / 2) + 1; k++) {
                    answer = Math.min(answer, (lst[j][0] - lst[i][0] + 2) * (can.get(k + (int) (N / 2) - 1) - can.get(k) + 2));
                }
            }
        }

        System.out.println(answer);

    } // end of main

} // end of class