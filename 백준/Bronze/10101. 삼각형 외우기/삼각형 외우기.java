import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        if (A == 60 && B == 60 && C == 60) {
            System.out.println("Equilateral");
        } else if (A + B + C == 180 && (A == B || B == C || C == A)) {
            System.out.println("Isosceles");
        } else if (A + B + C == 180 && A != B && B != C) {
            System.out.println("Scalene");
        } else if (A + B + C != 180) {
            System.out.println("Error");
        }


    } // end of main

} // end of class