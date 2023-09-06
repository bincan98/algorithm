import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st= new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		System.out.println(rev(rev(X) + rev(Y)));
	} // end of main

	private static int rev(int a) {
		int result = 0;
		List<Integer> list = new ArrayList<>();
		
		while (a != 0) {
			list.add(a % 10);
			a /= 10;
		}
		
		for (int i = 0; i < list.size(); i++) {
			result *= 10;
			result += list.get(i);
		}
		return result;
	} // end of rev
} // end of class