import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {


        int[] arr1 = new int[3];
        int[] arr2 = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += Math.max(0, arr2[i] - arr1[i]);
        }

        System.out.println(answer);
    } // end of main

} // end of class