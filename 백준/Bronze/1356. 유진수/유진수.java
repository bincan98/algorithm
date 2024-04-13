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

        if (String.valueOf(N).length() == 1) {
            System.out.println("NO");
            return;
        }

        int left = 1;
        int right = 1;

        for (int i = 0; i < String.valueOf(N).length() - 1; i++) {
            left = 1;
            right = 1;
            for (int j = 0; j < i + 1; j++) {
                left *= Integer.parseInt(String.valueOf(N).substring(j, j + 1));
            }
            for (int j = i + 1; j < String.valueOf(N).length(); j++) {
                right *= Integer.parseInt(String.valueOf(N).substring(j, j + 1));
            }
            if (left == right) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");

    } // end of main

} // end of class