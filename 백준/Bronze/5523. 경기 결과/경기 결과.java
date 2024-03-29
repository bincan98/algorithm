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

        int[] answer = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b)
                answer[0] += 1;
            else if (a < b)
                answer[1] += 1;
        }

        System.out.println(answer[0] + " " + answer[1]);

    } // end of main

} // end of class