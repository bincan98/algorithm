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
    	
    	int[] arr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
    	
    	for (int i = 0; i < N; i++) {
			if (arr[i] >= 300) 
				System.out.print(1 + " ");
			else if(275 <= arr[i] && arr[i] < 300)
				System.out.print(2 + " ");
			else if(250 <= arr[i] && arr[i] < 275)
				System.out.print(3 + " ");
			else
				System.out.print(4 + " ");
		}

    } // end of main

} // end of class