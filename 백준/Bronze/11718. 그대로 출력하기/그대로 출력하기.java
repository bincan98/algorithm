import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		while (true) {
			String s = br.readLine();
			
			if (s == null) {
				break;
			}
			
			System.out.println(s);
		}
		
	}
}