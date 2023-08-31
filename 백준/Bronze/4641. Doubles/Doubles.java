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
		while (true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			
			if (a == -1) break;
			
			List<Integer> lst = new ArrayList<>();
			
			while (a != 0) {
				lst.add(a);
				a = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 0;
			for (int i = 0; i < lst.size(); i++) {
				for (int j = 0; j < lst.size(); j++) {
					if (lst.get(i) * 2 == lst.get(j)) {
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	} // end of main
} // end of class