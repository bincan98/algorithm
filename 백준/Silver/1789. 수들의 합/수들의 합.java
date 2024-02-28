import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        long S = Long.parseLong(br.readLine());

        long answer = 0;
        long sum = 0;
        for (int i = 1; i < 100_000; i++) {
            sum += i;
            if (sum > S) {
                answer = i - 1;
                break;
            }
        }

        System.out.println(answer);
    } // end of main

} // end of class