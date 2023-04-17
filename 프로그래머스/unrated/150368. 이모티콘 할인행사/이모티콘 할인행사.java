public class Solution{
	private static int[] numbers;
	static int[] discount = {10,20,30,40};
	private static int[] answer;

	static public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        
        numbers = new int[emoticons.length];
        perm(0, emoticons.length, users, emoticons);
        
        return answer;
    }
	
	private static void perm(int index, int N, int[][] users, int[] emoticons) {
		if(index == N) {
			int[] result = cal(users, emoticons);
			
			if(answer[0] < result[0]) {
				answer[0] = result[0];
				answer[1] = result[1];
			} else if(answer[0] == result[0]) {
				if(answer[1] < result[1])
					answer[1] = result[1];
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			numbers[index] = discount[i];
			perm(index + 1, N, users, emoticons);
		}
	}

	private static int[] cal(int[][] users, int[] emoticons) {
		int[] sum = new int[2];
		for (int i = 0; i < users.length; i++) {
			int result = 0;
			for (int j = 0; j < emoticons.length; j++) {
				if(users[i][0] <= numbers[j]) {
					result += emoticons[j] * (100 - numbers[j]) * 0.01;
				}
			}
			if(result >= users[i][1]) {
				sum[0]++;
			} else {
				sum[1] += result;
			}
		}
		return sum;
	}
} // end of class
