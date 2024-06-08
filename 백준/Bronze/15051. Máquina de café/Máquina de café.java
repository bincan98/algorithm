import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int[] lst = new int[3];
        for (int i = 0; i < 3; i++) {
            lst[i] = Integer.parseInt(br.readLine());
        }

        int answer = Integer.MAX_VALUE;
        answer = Math.min(answer, lst[1] * 2 + lst[2] * 4);
        answer = Math.min(answer, lst[0] * 2 + lst[2] * 2);
        answer = Math.min(answer, lst[0] * 4 + lst[1] * 2);

        System.out.println(answer);

    } // end of main

} // end of class