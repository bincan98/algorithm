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

        boolean answer = false;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'S') {
                    answer = true;
                    break;
                }
            }

            if (answer) {
                System.out.println(s);
                break;
            }
        }

    } // end of main

} // end of class