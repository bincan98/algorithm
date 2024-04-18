import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        while (true) {
            String s = br.readLine();
            if (s.equals("#"))
                break;
            int answer = 0;
            for (int i = 0; i < s.length(); i++) {
                answer += (int) (cal(s.charAt(i)) * Math.pow(8, s.length() - i - 1));
            }
            System.out.println(answer);
        }

    } // end of main

    private static int cal(char c) {
        if (c == '-')
            return 0;
        else if (c == '\\')
            return 1;
        else if (c == '(')
            return 2;
        else if (c == '@')
            return 3;
        else if (c == '?')
            return 4;
        else if (c == '>')
            return 5;
        else if (c == '&')
            return 6;
        else if (c == '%')
            return 7;
        else if (c == '/')
            return -1;
        return 0;
    }

} // end of class