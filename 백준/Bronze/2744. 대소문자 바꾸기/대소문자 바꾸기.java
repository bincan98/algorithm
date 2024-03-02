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
        
        for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				System.out.print(Character.toLowerCase(s.charAt(i)));
			} else {
				System.out.print(Character.toUpperCase(s.charAt(i)));
			}
		}

    } // end of main

} // end of class