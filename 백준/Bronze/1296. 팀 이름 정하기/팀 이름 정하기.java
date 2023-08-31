import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String y = br.readLine();
		
		int y_l = 0;
		int y_o = 0;
		int y_v = 0;
		int y_e = 0;
		for (int i = 0; i < y.length(); i++) {
			switch (y.charAt(i)) {
			case 'L':
				y_l++;
				break;
			case 'O':
				y_o++;
				break;
			case 'V':
				y_v++;
				break;
			case 'E':
				y_e++;
				break;
			default:
				break;
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		
		String[] lst = new String[N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			lst[i] = s;
		}
		
		Arrays.sort(lst);
		
		int probability = -1;
		String answer = "";
		int l = 0;
		int o = 0;
		int v = 0;
		int e = 0;
		for (int i = 0; i < N; i++) {
			l = y_l;
			o = y_o;
			v = y_v;
			e = y_e;
			for (int j = 0; j < lst[i].length(); j++) {
				switch (lst[i].charAt(j)) {
				case 'L':
					l++;
					break;
				case 'O':
					o++;
					break;
				case 'V':
					v++;
					break;
				case 'E':
					e++;
					break;
				default:
					break;
				}				
			}
			int con_probability = ((l+o) * (l+v) * (l+e) * (o+v) * (o+e) * (v+e)) % 100;
			if (con_probability > probability) {
				probability = con_probability;
				answer = lst[i];
			}
		}
		
		System.out.println(answer);
	}
}