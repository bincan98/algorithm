import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			
			int[] gandal = new int[6];
			int[] sawoo =  new int[7];
			int[] scoreG = {1, 2, 3, 3, 4, 10};
			int[] scoreS = {1, 2, 2, 2, 3, 5, 10};
			for (int j = 0; j < 6; j++) {
				gandal[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 7; j++) {
				sawoo[j] = Integer.parseInt(st.nextToken());
			} // 입력 완료
			
			int resultGandal = 0;
			int resultSawoo = 0;
			
			for (int j = 0; j < 6; j++) {
				switch (j) {
				case 0:
					resultGandal += gandal[j];
					break;
				case 1:
					resultGandal += 2 * gandal[j];
					break;
				case 2:
					resultGandal += 3 * gandal[j];
					break;
				case 3:
					resultGandal += 3 * gandal[j];
					break;
				case 4:
					resultGandal += 4 * gandal[j];
					break;
				case 5:
					resultGandal += 10 * gandal[j];
					break;
				}
				
			}
			
			for (int j = 0; j < 7; j++) {
				switch (j) {
				case 0:
					resultSawoo += sawoo[j];
					break;
				case 1:
					resultSawoo += 2 * sawoo[j];
					break;
				case 2:
					resultSawoo += 2 * sawoo[j];
					break;
				case 3:
					resultSawoo += 2 * sawoo[j];
					break;
				case 4:
					resultSawoo += 3 * sawoo[j];
					break;
				case 5:
					resultSawoo += 5 * sawoo[j];
					break;
				case 6:
					resultSawoo += 10 * sawoo[j];
					break;
				}
			}
			
//			System.out.println(resultGandal);
//			System.out.println(resultSawoo);
			
			System.out.print("Battle " + i+": ");
			if(resultGandal > resultSawoo) {
				System.out.println("Good triumphs over Evil");
			}else if(resultSawoo > resultGandal) {
				System.out.println("Evil eradicates all trace of Good");
			} else {
				System.out.println("No victor on this battle field");
			}
			
		}
	}
}