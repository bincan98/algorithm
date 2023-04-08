import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int N, answer;
	private static boolean[] isSelected;
	private static int[] operand, operand2;
	private static char[] operator, operator2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		if(N==1) { // N이 1일 경우 예외 처리
			System.out.println(Integer.parseInt(br.readLine()));
			return;
		}
		String s = br.readLine();
		
		operand = new int[N/2+1]; // 피연산자를 입력 받을 배열
		operator = new char[N/2]; // 연산자를 입력받을 배열
		for (int i = 0; i < N; i++) {
			if(i%2==0) {
				operand[i/2] = s.charAt(i) - '0';
			} else {
				operator[i/2] = s.charAt(i);
			}
		} // 입력 완료
		
		answer = -987654321; // 값이 음수가 나올 수 있으므로 최대한 음의값으로 초기화하기
		isSelected = new boolean[N/2]; // 연산자의 괄호를 표시할 배열
		subSet(0);
		
		System.out.println(answer);
	} // end of main

	private static void subSet(int index) {
		if(index >= N/2) { // 부분집합이 완성되면
			operand2 = new int[N/2+1]; // 1차 계산이 끝나고 피연산자를 입력 받을 배열
			operator2 = new char[N/2]; // 1차 계산이 끝나고 연산자를 입력받을 배열
			
			// 초기값 채우기
			Arrays.fill(operator2, '0');
			
			// 1차 계산
			int cnt = -1; // 초기식의 인덱스
			int cnt2 = -1; // 1차계산이 끝나고 식의 인덱스
			while (++cnt < N/2) {
				cnt2++;
				if(isSelected[cnt]) { // 괄호가 있다면
					operand2[cnt2] = cal(operand[cnt], operator[cnt], operand[cnt+1]); // 피연산자 계산해서 넣기
					if(cnt != N/2-1) operator2[cnt2] = operator[cnt+1]; // 마지막 연산자가 아니었다면 뒤의 연산자도 넣어주기 (어차피 false일테니)
					if(cnt == N/2-2) operand2[cnt2+1] = operand[cnt+2]; // 만약 마지막에서 두번째 연산자라면 피연산자가 하나남으므로 그것도 넣어주기
					cnt += 1;
				} else { // 괄호가 없다면
					operand2[cnt2] = operand[cnt]; // 피연산자 그대로 넣기
					operator2[cnt2] = operator[cnt]; // 연산자 그대로 넣기
					if(cnt == N/2-1) operand2[cnt2+1] = operand[cnt+1]; // 마지막 연산자 였다면 남은 피연산자 하나도 넣기 
				}
				
			}
			
			// 2차 계산
			int i = -1;
			int o1 = operand2[0];
			while(operator2[++i] != '0') { // 연산자가 없을때까지
				char op = operator2[i];
				int o2 = operand2[i+1];
				o1 = cal(o1, op, o2); // 계산해서 o1에 넣어주기
				if(i == N/2-1) break; // 만약 연산자를 다 봤다면 나가기
			}
			
			answer = Math.max(answer, o1); // o1을 answer에 넣어보기
			
			return;
		}
		
		// 괄호를 쳤다면
		isSelected[index] = true;
		// 다음 괄호는 다다음 연산자에만 가능
		subSet(index+2);
		
		// 괄호 풀고
		isSelected[index] = false;
		// 다음 연산자 보기
		subSet(index+1);
		
	} // end of subSet

	private static int cal(int operand1, char operator, int operand2) { // 계산 함수
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