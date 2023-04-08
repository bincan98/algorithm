import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N;
	private static boolean[] isSelected;
	private static int[] operand;
	private static char[] operator;
	private static int[] operand2;
	private static char[] operator2;
	private static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println(Integer.parseInt(br.readLine()));
			return;
		}
		String s = br.readLine();
		
		
		operand = new int[N/2+1];
		operator = new char[N/2];
		for (int i = 0; i < N; i++) {
			if(i%2==0) {
				operand[i/2] = s.charAt(i) - '0';
			} else {
				operator[i/2] = s.charAt(i);
			}
		}
		
		answer = -987654321;
		isSelected = new boolean[N/2];
		subSet(0);
		
		System.out.println(answer);
	} // end of main

	private static void subSet(int index) {
		if(index >= N/2) {
			operand2 = new int[N/2+1];
			operator2 = new char[N/2];
			
			Arrays.fill(operator2, '0');
			
			int cnt = -1;
			int cnt2 = -1;
			while (++cnt < N/2) {
				cnt2++;
				if(isSelected[cnt]) {
					operand2[cnt2] = cal(operand[cnt], operator[cnt], operand[cnt+1]);
					if(cnt != N/2-1) operator2[cnt2] = operator[cnt+1]; 
					if(cnt == N/2-2) operand2[cnt2+1] = operand[cnt+2]; 
					cnt += 1;
				} else {
					operand2[cnt2] = operand[cnt]; 
					operator2[cnt2] = operator[cnt]; 
					if(cnt == N/2-1) operand2[cnt2+1] = operand[cnt+1]; 
				}
				
			}
			
			int i = -1;
			int o1 = operand2[0];
			while(operator2[++i] != '0') {
				char op = operator2[i];
				int o2 = operand2[i+1];
				o1 = cal(o1, op, o2);
				if(i == N/2-1) break;
			}
			
			answer = Math.max(answer, o1);
			
			return;
		}
		
		isSelected[index] = true;
		subSet(index+2);
		
		isSelected[index] = false;
		subSet(index+1);
		
	} // end of subSet

	private static int cal(int operand1, char operator, int operand2) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		}
		return 0;
	} // end of cal
} // end of class