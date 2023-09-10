import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		
		boolean[] ls = new boolean[31];
		
		for (int i = 0; i < 28; i++) {
			ls[Integer.parseInt(br.readLine())] = true;
		}
		
		for (int i = 1; i < 31; i++) {
			if (!ls[i]) System.out.println(i);
		}
	}
}