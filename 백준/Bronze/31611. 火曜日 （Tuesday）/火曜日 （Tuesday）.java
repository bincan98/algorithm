import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int X = Integer.parseInt(br.readLine());

        if (X % 7 == 2) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    } // end of main

} // end of class