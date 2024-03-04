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

        int index = 665;

        while (N != 0) {
            index += 1;
            if (isValid(index) == true) {
                N -= 1;
            }
        }

        System.out.println(index);

    } // end of main

    private static boolean isValid(int index) {
        int repeat = 0;
        while (index != 0) {
            if (index % 10 == 6) {
                repeat += 1;
                if (repeat == 3)
                    return true;
            } else {
                repeat = 0;
            }
            index /= 10;
        }
        return false;
    }

} // end of class