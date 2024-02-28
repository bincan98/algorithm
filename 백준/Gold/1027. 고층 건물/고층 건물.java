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
        int[] building = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        } // 입력완료

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int result = 0;
            double maxSlope = building[i]/0.5;
            for (int j = i - 1; j >= 1; j--) {
                if (maxSlope > ((double) building[i] - building[j]) / (i - j)) {
                    maxSlope = ((double) building[i] - building[j]) / (i - j);
                    result += 1;
                }
            }
            double minSlope = -building[i]/0.5;
            for (int j = i + 1; j <= N; j++) {
                if (minSlope < ((double) building[j] - building[i]) / (j - i)) {
                    minSlope = ((double) building[j] - building[i]) / (j - i);
                    result += 1;
                }
            }
            answer = Math.max(answer, result);
        } // end of for i
        
        System.out.println(answer);
    } // end of main

} // end of class