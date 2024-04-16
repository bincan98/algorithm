import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, answer;
    private static int[] check;
    private static Boolean[] disabled;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        printS("@@@@@");
        printS("@");
        printS("@@@@@");
        printS("@");
        printS("@@@@@");

    } // end of main

    private static void printS(String s) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(s);
            }
            System.out.println();
        }
    } // end of printS

} // end of class