package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888 {

    public static int n;
    public static int[] num = new int[11];
    public static int[] operator = new int[4];
    public static int max = Integer.MIN_VALUE; // 최대값
    public static int min = Integer.MAX_VALUE; // 최소값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 숫자 개수 입력

        // 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // 연산 개수 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operator.length; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // 연산
        func(num[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void func(int x, int k) {
        if (k == n) {
            // 최대, 최소 비교
            max = Math.max(max, x);
            min = Math.min(min, x);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] <= 0) continue; // 연산자 개수 0이하 -> 다음 반복 시작
            operator[i]--; // 연산자 개수 감소
            switch (i) {
                case 0:
                    func(x + num[k], k + 1); // 연산
                    break;
                case 1:
                    func(x - num[k], k + 1);
                    break;
                case 2:
                    func(x * num[k], k + 1);
                    break;
                case 3:
                    func(x / num[k], k + 1);
                    break;
            }
            operator[i]++; // 재귀 호출이 완료되면 연산자 개수 원상 복구
        }

    }

}
