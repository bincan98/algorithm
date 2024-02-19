import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static String A, B, C;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] lst = new int[5];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(lst[i] - (L * P) + " ");
        }

    } // end of main

} // end of class