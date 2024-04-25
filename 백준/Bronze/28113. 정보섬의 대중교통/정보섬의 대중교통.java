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
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if (N > B) {
            System.out.println("Bus");
        } else if (A > B) {
            System.out.println("Subway");
        } else if (A < B) {
            System.out.println("Bus");
        } else {
            System.out.println("Anything");
        }

    } // end of main

} // end of class