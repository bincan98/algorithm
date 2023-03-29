import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int[] arr;
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		arr = new int[1_000_001];
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 2; i < 1_000_001; i++) {
			int min = Integer.MAX_VALUE;
			if(i % 3 == 0) min = Math.min(min, arr[i/3]+1);
			if(i % 2 == 0) min = Math.min(min, arr[i/2]+1);
			if(i - 1 > 0) min = Math.min(min, arr[i-1]+1);
			arr[i] = min;
		}
		
		System.out.println(arr[N]);
		
	} // end of main
} // end of class