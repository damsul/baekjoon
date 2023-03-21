package algorithm.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24060 {

    public static int n, k, cnt, ans;
    public static int[] arr = new int[500_005];
    public static int[] tmp = new int[500_005];


    /*public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int left = st;
        int right = mid;

        for (int i = st; i < en; i++) {
            cnt++;
            if (right == en) tmp[i] = arr[left++];
            else if (left == mid) tmp[i] = arr[right++];
            else if (arr[left] <= arr[right]) tmp[i] = arr[left++];
            else tmp[i] = arr[right++];

            if (cnt == k) {
                ans = tmp[i];
                break;
            }
        }
        for (int i = st; i < en; i++) {
            arr[i] = tmp[i];
        }
    }
    public static void mergeSort(int st, int en) {
        if (en - st == 1) return;

        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }
    */

    public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int left = st;
        int right = mid + 1;
        int t = 0;

        while (left <= mid && right <= en) {
            if (arr[left] <= arr[right]) {
                tmp[t++] = arr[left++];
            } else tmp[t++] = arr[right++];
        }
        while (left <= mid)
            tmp[t++] = arr[left++];
        while (right <= en)
            tmp[t++] = arr[right++];

        left = st;
        t = 0;
        while (left <= en) {
            cnt++;
            if (cnt == k) {
                ans = tmp[t];
            }
            arr[left++] = tmp[t++];

        }
    }

    public static void mergeSort(int st, int en) {
        if (st >= en) return;

        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid + 1, en);
        merge(st, en);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = -1;
        mergeSort(0, n - 1);

        System.out.println(ans);
    }

}
