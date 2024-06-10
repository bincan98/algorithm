import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int a = Integer.parseInt(br.readLine());

        for (int i = 1; i <= a; i++) {
            System.out.print(i + " ");
            if (i % 6 == 0) {
                System.out.print("Go! ");
            }
        }

        if (a % 6 != 0) {
            System.out.print("Go! ");
        }

    } // end of main

} // end of class