import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static int N, k;

    public static void main(String[] args) throws IOException {

        N  = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        long s = 1;
        long e = (long) N * N;

        long answer = 0;
        while (true) {
            long mid = (s + e) / 2;
            long cntSmallEqual = 0;
            long cntSmall = 0;
            for (int i = 1; i < N+1; i++) {
                cntSmallEqual += Math.min(N, mid / i);
                cntSmall += Math.min(N, (mid - 1) / i);
            }
            if (cntSmall < k && k <= cntSmallEqual) {
                answer = mid;
                break;
            } else if (k <= cntSmall) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        System.out.println(answer);

    } // end of main

} // end of class