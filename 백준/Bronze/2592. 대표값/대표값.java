import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(br.readLine());
            sum += x;
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int maxKey = -1;
        int maxValue = 0;
        for (int key: map.keySet()) {
            if (map.get(key) > maxValue) {
                maxKey = key;
                maxValue = map.get(key);
            }
        }
        System.out.println(sum / 10);
        System.out.println(maxKey);

    } // end of main

} // end of class