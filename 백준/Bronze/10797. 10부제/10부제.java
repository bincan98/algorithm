import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int A = Integer.parseInt(br.readLine());

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            if (Integer.parseInt(st.nextToken()) == A)
                answer += 1;
        }

        System.out.println(answer);

    } // end of main

} // end of class