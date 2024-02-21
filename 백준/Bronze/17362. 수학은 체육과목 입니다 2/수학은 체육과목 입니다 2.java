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

        switch (N % 8) {
            case 0:
                N = 2;
                break;
            case 7:
                N = 3;
                break;
            case 6:
                N = 4;
                break;
        }

        System.out.println(N % 8);

    } // end of main

} // end of class