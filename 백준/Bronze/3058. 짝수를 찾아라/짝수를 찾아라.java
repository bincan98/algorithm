import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int total = 0;
            int min = 102;
            for (int j = 0; j < 7; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a % 2 == 0) {
                    total += a;
                    min = Math.min(min, a);
                }
            }
            System.out.println(total + " " + min);
        }

    } // end of main

} // end of class