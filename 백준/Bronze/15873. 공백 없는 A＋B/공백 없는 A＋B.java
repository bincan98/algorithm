import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String s = br.readLine();

        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        if (s.length() == 2) {
            System.out.println(arr[0] + arr[1]);
        } else if (s.length() == 4) {
            System.out.println(arr[0] * 10 + arr[1] + arr[2] * 10 + arr[3]);
        } else {
            if (arr[1] == 0) {
                System.out.println(arr[0] * 10 + arr[1] + arr[2]);
            } else {
                System.out.println(arr[0] + arr[1] * 10 + arr[2]);
            }
        }

    } // end of main

} // end of class