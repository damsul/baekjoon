package algorithm.sort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _11652 {

    public static int N;
    public static long[] arr = new long[100005];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr, 0, N); // 배열 arr 인덱스 0 ~ N-1 까지 정렬


        long maxVal = -(1L << 62) - 1; // -2^62 - 1 : 등장 가능한 수의 최솟값보다 더 작은 값으로 초기화 설정
        int maxCnt = 0;
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i - 1]) cnt++;
            else {
                if (cnt > maxCnt) {
                    maxVal = arr[i - 1];
                    maxCnt = cnt;
                }
                cnt = 1;
            }
        }
        if (cnt > maxCnt) maxVal = arr[N - 1];
        System.out.println(maxVal);
    }

}
