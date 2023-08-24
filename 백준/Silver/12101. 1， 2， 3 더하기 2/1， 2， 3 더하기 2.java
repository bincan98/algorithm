import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	private static int n;
	private static int k;
	private static ArrayList<ArrayList<Integer>> answer;
	private static int cnt;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		answer = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> lst = new ArrayList<>();
		recur(lst, 0);
		
		if (k > cnt) {
			System.out.println(-1);
		} else {
			String str = "";
			for (int i = 0; i < answer.get(k-1).size(); i++) {
				str = str.concat(answer.get(k-1).get(i).toString());
				str = str.concat("+");
			}
			
			System.out.println(str.substring(0, str.length()-1));
		}
	} // end of main

	private static void recur(ArrayList<Integer> arr, int total) {
		if (total > n)
			return;
		if (total == n) {
			ArrayList<Integer> newarr = new ArrayList<>(arr);
			answer.add(newarr);
			cnt++;
			return;
		}
		arr.add(1);
		recur(arr, total + 1);
		arr.remove(arr.size()-1);
		arr.add(2);
		recur(arr, total + 2);
		arr.remove(arr.size()-1);
		arr.add(3);
		recur(arr, total + 3);
		arr.remove(arr.size()-1);
	}
} // end of class