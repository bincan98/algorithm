import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[] lst;
    private static int[][] delta;
    private static long[][] cnt;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lst = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        } // 입력 완료

        delta = new int[N][2];

        for (int i = 0; i < N-1; i++) {
            delta[i+1][0] = (lst[i] - lst[i+1] + M) % M;
            delta[i][1] = (lst[i+1] - lst[i] + M) % M;
        }

        cnt = new long[N][2];

        for (int i = 1; i < N; i++) {
            cnt[i][0] = cnt[i-1][0] + delta[i][0];
        }

        for (int i = N-2; i >= 0; i--) {
            cnt[i][1] = cnt[i+1][1] + delta[i][1];
        }

        long answer = Math.max(cnt[0][0], cnt[0][1]);
        int index = 1;
        for (int i = 0; i < N; i++) {
            if (answer > Math.max(cnt[i][0], cnt[i][1])) {
                answer = Math.max(cnt[i][0], cnt[i][1]);
                index = i + 1;
            }
        }

        System.out.println(index);
        System.out.println(answer);

    } // end of main

} // end of class