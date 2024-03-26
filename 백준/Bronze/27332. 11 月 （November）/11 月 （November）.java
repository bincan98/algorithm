import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        a += b * 7;

        if (a > 30)
            System.out.println(0);
        else
            System.out.println(1);

    } // end of main

} // end of class