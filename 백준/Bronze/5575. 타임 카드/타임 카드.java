import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int startH = Integer.parseInt(st.nextToken());
            int startM = Integer.parseInt(st.nextToken());
            int startS = Integer.parseInt(st.nextToken());
            int endH = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endS = Integer.parseInt(st.nextToken());

            int answerH = endH - startH;
            int answerM = endM - startM;
            int answerS = endS - startS;

            if (answerS < 0) {
                answerS += 60;
                answerM -= 1;
            }
            if (answerM < 0) {
                answerM += 60;
                answerH -= 1;
            }

            System.out.println(answerH + " " + answerM + " " + answerS);
        }

    } // end of main

} // end of class