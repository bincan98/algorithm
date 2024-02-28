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

        int answer = hanoi(N, 1, 3, 2);

        System.out.println(answer);
        System.out.println(sb.toString());

    } // end of main

    private static int hanoi(int cnt, int from, int to, int left) {
        if (cnt == 0) return 0;
        int result = 0;
        result += hanoi(cnt - 1, from, left, to);
        sb.append(from + " " + to + "\n");
        result += hanoi(cnt - 1, left, to, from);
        return result + 1;
    }

} // end of class