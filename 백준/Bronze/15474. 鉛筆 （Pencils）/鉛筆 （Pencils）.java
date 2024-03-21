import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

    	st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	int C = Integer.parseInt(st.nextToken());
    	int D = Integer.parseInt(st.nextToken());
    	
    	int answer = 0;
    	
    	if (N % A == 0) {
    		answer = B * (N / A);
    	} else {
    		answer = B * (N / A + 1);
    	}
    	
    	if (N % C == 0) {
    		answer = Math.min(answer, D * (N / C));
    	} else {
    		answer = Math.min(answer, D * (N / C + 1));    		
    	}
    	
    	System.out.println(answer);
  
    } // end of main

} // end of class