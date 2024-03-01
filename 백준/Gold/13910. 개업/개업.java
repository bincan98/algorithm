import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] wok = new int[M];
        List<Integer> allWok = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int w = Integer.parseInt(st.nextToken());
            wok[i] = w;
            allWok.add(w);
        }

        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (wok[i] + wok[j] > N)
                    continue;
                allWok.add(wok[i] + wok[j]);
            }
        }

        Collections.sort(allWok);

        int[] visited = new int[N + 1];
        Queue<Integer> q = new ArrayDeque<>();

        Arrays.fill(visited, -1);

        for (int w: allWok) {
            visited[w] = 1;
            q.offer(w);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int w: allWok) {
                if (cur + w > N)
                    break;
                if (visited[cur + w] == -1) {
                    visited[cur + w] = visited[cur] + 1;
                    q.offer(cur + w);
                }
            }
        }

        System.out.println(visited[N]);

    } // end of main

} // end of class