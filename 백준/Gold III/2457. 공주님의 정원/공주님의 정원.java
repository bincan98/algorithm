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

        int[][] lst = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lst[i][0] = Integer.parseInt(st.nextToken());
            lst[i][1] = Integer.parseInt(st.nextToken());
            lst[i][2] = Integer.parseInt(st.nextToken());
            lst[i][3] = Integer.parseInt(st.nextToken());
        } // 입력 완료

        Arrays.sort(lst, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]).reversed());
        int lastMonth = 3;
        int lastDay = 1;
        int answer = 0;
        boolean isPossible = true;
        int i = 0;
        int startMonth = 0, startDay = 0, endMonth = 0, endDay = 0;
        while (i <= N) {
            if (lastMonth == 12) break;
            if (i < N) {
                startMonth = lst[i][0]; startDay = lst[i][1]; endMonth = lst[i][2]; endDay = lst[i][3];
            }
            if (i == N || startMonth > lastMonth || (startMonth == lastMonth && startDay > lastDay)) {
                if (pq.isEmpty()) {
                    isPossible = false;
                    break;
                } else {
                    answer += 1;
                    int[] temp = pq.poll();
                    lastMonth = temp[0];
                    lastDay = temp[1];
                }
            }
            if (startMonth < lastMonth || (startMonth == lastMonth && startDay <= lastDay)) {
                pq.offer(new int[] {endMonth, endDay});
            }
            i += 1;
        } // end of while

        if (lastMonth != 12) isPossible = false;

        if (isPossible)
            System.out.println(answer);
        else
            System.out.println(0);

    } // end of main

} // end of class