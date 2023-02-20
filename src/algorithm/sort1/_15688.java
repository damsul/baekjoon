package algorithm.sort1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15688 {

    public static int N;
    public static int MAX = 2000000;
    public static int HALF = MAX / 2;
    public static int[] arr = new int[MAX + 2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num + HALF]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= MAX; i++) {
            while (arr[i] > 0) {
                sb.append(i - HALF).append('\n');
                arr[i]--;
            }
        }
        System.out.println(sb);
    }

}
