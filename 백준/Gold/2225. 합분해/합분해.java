import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.math.BigInteger;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        BigInteger answer = new BigInteger("1");
        for (int i = 1; i < K; i++) {
            answer = answer.multiply(BigInteger.valueOf(N + K - i));
            answer = answer.divide(BigInteger.valueOf(i));
        }

        System.out.println(answer.remainder(BigInteger.valueOf(1_000_000_000)));

    } // end of main

} // end of class