import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        int[] lst = new int[N];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            sum += a;
            lst[i] = a;
        }

        for (int i = 0; i < N; i++) {
            System.out.println(lst[i] * total / sum);
        }

    } // end of main

} // end of class