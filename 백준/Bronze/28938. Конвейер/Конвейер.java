import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Integer.parseInt(st.nextToken());
        }

        if (answer < 0) {
            System.out.println("Left");
        } else if (answer == 0) {
            System.out.println("Stay");
        } else {
            System.out.println("Right");
        }

    } // end of main

} // end of class