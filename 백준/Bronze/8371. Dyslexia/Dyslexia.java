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
        String s1 = br.readLine();
        String s2 = br.readLine();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                answer += 1;
        }

        System.out.println(answer);

    } // end of main

} // end of class