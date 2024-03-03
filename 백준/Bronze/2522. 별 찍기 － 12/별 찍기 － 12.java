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
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N - i - 1; j++) {
				System.out.print(" ");
			}
    		for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
    	for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < N - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

    } // end of main

} // end of class