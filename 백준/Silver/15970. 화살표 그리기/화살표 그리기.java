import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] adjList = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			adjList[i] = new ArrayList<Integer>();
			adjList[i].add(-1);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjList[y].add(x);
		}
		
		for (int i = 0; i < N+1; i++) {
			Collections.sort(adjList[i]);
			adjList[i].add(-1);
		}
		
		int answer = 0;
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < adjList[i].size(); j++) {
				if (adjList[i].get(j) == -1) continue;
				if (adjList[i].get(j-1) == -1) {
					answer += adjList[i].get(j+1) - adjList[i].get(j);
				} else if (adjList[i].get(j+1) == -1) {
					answer += adjList[i].get(j) - adjList[i].get(j-1);
				} else {
					answer += Math.min(adjList[i].get(j+1) - adjList[i].get(j), adjList[i].get(j) - adjList[i].get(j-1));
				}
			}
		}
		
		System.out.println(answer);
		
	}
}