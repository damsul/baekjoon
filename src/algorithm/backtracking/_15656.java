package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15656 {

    public static int N, M;
    public static int[] arr = new int[10];
    public static int[] num = new int[10];
    public static StringBuilder sb = new StringBuilder();

    public static void func(int k) { // 현재 k개 까지 수를 택함
        if (k == M) { // M개를 모두 택했으면
            for (int i = 0; i < M; i++) {
                sb.append(num[arr[i]]).append(' '); // arr에 저장해둔 인덱스를 참고해 값을 출력
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[k] = i; // k번째 수를 인덱스 i로 저장
            func(k+1); // 다음 수를 정하기 위해 한 단계 더 진행함.
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken()); // 입력받은 정수 저장
        }
        Arrays.sort(num, 0, N); // 입력받은 정수 정렬

        func(0);
        System.out.println(sb);
    }

}
