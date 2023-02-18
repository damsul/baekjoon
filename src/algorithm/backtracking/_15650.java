package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15650 {

    public static int N, M;
    public static int[] arr = new int[10];
    public static boolean[] visited = new boolean[10];

    public static StringBuilder sb = new StringBuilder();
    public static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        int st = 1;
        if (k != 0) st = arr[k - 1] + 1;

        for (int i = st; i <= N; i++) {
            if (visited[i]) continue;
            arr[k] = i;
            visited[i] = true;
            func(k + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        func(0);

        System.out.println(sb);
    }

}
