package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15655 {
    public static int N, M;
    public static int[] arr = new int[10];
    public static int[] data = new int[10];
    public static boolean[] visited = new boolean[10];

    public static StringBuilder sb = new StringBuilder();
    public static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(data[arr[i]]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int st = 0;
        if (k != 0) st = arr[k-1] + 1;

        for (int i = st; i < N; i++) {
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
        N = Integer.parseInt(st.nextToken()); // 자연수 N개
        M = Integer.parseInt(st.nextToken()); // 수열 M개

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data, 0, N);

        func(0);
        System.out.println(sb);
    }

}
