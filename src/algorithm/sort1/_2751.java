package algorithm.sort1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2751 {
    public static int N;
    public static int[] arr = new int[1000005];
    public static int[] tmp = new int[1000005];

    public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int left = st;
        int right = mid;

        for (int i = st; i < en; i++) {
            if (right == en) tmp[i] = arr[left++];
            else if (left == mid) tmp[i] = arr[right++];
            else if (arr[left] <= arr[right]) tmp[i] = arr[left++];
            else  tmp[i] = arr[right++];
        }
        for (int i = st; i < en; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void mergeSort(int start, int end) {
        if (start + 1 == end) return;

        int mid = (start + end) / 2;

        mergeSort(start, mid);
        mergeSort(mid, end);
        merge(start, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N);
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

}
