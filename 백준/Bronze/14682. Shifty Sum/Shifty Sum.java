import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    private static int N, k;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i <= k; i++) {
            sum += N;
            N *= 10;
        }

        System.out.println(sum);

    } // end of main

} // end of class