package algorithm.sort1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10989 {
    public static int N;
    public static int[] arr = new int[10001];
    public static int[] tmp = new int[10001];

    public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int left = st;
        int right = mid;

        for (int i = st; i < en; i++) {
            if (right == en) tmp[i] = arr[left++];
            else if (left == mid) tmp[i] = arr[right++];
            else if (arr[left] <= arr[right]) tmp[i] = arr[left++];
            else tmp[i] = arr[right++];
        }
        for (int i = st; i < en; i++) {
            arr[i] = tmp[i];
        }
    }
    public static void mergeSort(int st, int en) {
        if (en - st == 1) {
            return;
        }

        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            // arr[i] = Integer.parseInt(br.readLine());
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }

//        mergeSort(0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 10000; i++) {
//            sb.append(arr[i]).append('\n');
            while (arr[i] > 0) {
                sb.append(i).append('\n');
                arr[i]--;
            }
        }
        System.out.println(sb);
    }

}
