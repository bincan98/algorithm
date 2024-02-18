import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    private static String A, B, C;

    public static void main(String[] args) throws IOException {

        A  = br.readLine();
        B  = br.readLine();
        C  = br.readLine();

        System.out.println(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C));
        System.out.println(Integer.parseInt(A + B) - Integer.parseInt(C));

    } // end of main

} // end of class