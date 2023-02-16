package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11729 {

    public static StringBuilder sb = new StringBuilder();
    public static void hanoi(int a, int b, int n) {
        if (n == 1) {
//            System.out.println(a + " " + b);
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }

        hanoi(a, 6 - a - b, n - 1);
//        System.out.println(a + " " + b);
        sb.append(a).append(" ").append(b).append("\n");
        hanoi(6 - a - b, b, n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        System.out.println((1 << N) - 1);
        sb.append((1 << N) - 1).append("\n");
        hanoi(1, 3, N);
        System.out.println(sb);
    }
}
