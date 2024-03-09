import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        int day = 0;
        if (A % C == 0)
            day = Math.max(day, A / C);
        else
            day = Math.max(day, A / C + 1);

        if (B % D == 0)
            day = Math.max(day, B / D);
        else
            day = Math.max(day, B / D + 1);

        System.out.println(L - day);
    } // end of main

} // end of class