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
        } // 입력 완료

        Arrays.sort(lst, Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o -> o[0]));

        int endTime = -1;
        int answer = 0;
        for (int[] time:lst) {
            if (time[0] >= endTime) {
                answer += 1;
                endTime = time[1];
            }
        }

        System.out.println(answer);

    } // end of main

} // end of class