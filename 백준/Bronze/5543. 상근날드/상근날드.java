import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int burger = 2000;
        for (int i = 0; i < 3; i++) {
            burger = Math.min(burger, Integer.parseInt(br.readLine()));
        }

        int drink = 2000;
        for (int i = 0; i < 2; i++) {
            drink = Math.min(drink, Integer.parseInt(br.readLine()));
        }

        System.out.println(burger + drink - 50);

    } // end of main

} // end of class