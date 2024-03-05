import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int M = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        if (M < 2) {
            System.out.println("Before");
        } else if (M > 2) {
            System.out.println("After");
        } else {
            if (D < 18) {
                System.out.println("Before");
            } else if (D > 18) {
                System.out.println("After");
            } else {
                System.out.println("Special");
            }
        }


    } // end of main

} // end of class