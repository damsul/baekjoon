package algorithm.sort2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class _1431 {
    public static int N;
    public static String[] arr = new String[55];
    public static String[] tmp = new String[55];

    public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int left = st;
        int right = mid;

        for (int i = st; i < en; i++) {
            if (right == en) tmp[i] = arr[left++];
            else if (left == mid) tmp[i] = arr[right++];
            else if (arr[left].length() < arr[right].length()) tmp[i] = arr[left++]; // 길이 a < b 인 경우
            else if (arr[left].length() == arr[right].length()) { // 길이 a = b 인 경우
                int a = digitsSum(arr[left]); // a 자리수 합
                int b = digitsSum(arr[right]); // b 자리수 합
                if (a < b) tmp[i] = arr[left++]; // 합 a <= b 인 경우
                else if (a > b)tmp[i] = arr[right++]; // 합 a > b 인 경우
                // 사전 순으로 정렬
                else if (arr[left].compareTo(arr[right]) < 0) tmp[i] = arr[left++]; // a < b 사전 순 정렬
                else tmp[i] = arr[right++]; // a > b 사전 순 정렬
            }
            else tmp[i] = arr[right++]; // 길이 a > b 인 경우

        }
        for (int i = st; i < en; i++) {
            arr[i] = tmp[i];
        }
    }

    private static int digitsSum(String s) {
        int sum = 0;
        for (int j = 0; j < s.length(); j++) { // a 자리수 합
            if (s.charAt(j) < '0' || s.charAt(j) > '9') continue;
            sum += s.charAt(j) - '0';
        }
        return sum;
    }

    public static void mergeSort(int st, int en) {
        if (en - st == 1) return;
        int mid = (st + en) / 2;

        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
//        방법 1 : merge sort 구현
//        mergeSort(0, N);

        // 방법 2 : Comparator Override method
        Arrays.sort(arr, 0, N, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) return o1.length() - o2.length();
                else if (digitsSum(o1) < digitsSum(o2)) return -1;
                else if (digitsSum(o1) > digitsSum(o2)) return 1;
                else return o1.compareTo(o2);
            }
        });
//        Arrays.sort(arr, 0, N, (o1, o2) -> {
//            if (o1.length() != o2.length()) return o1.length() - o2.length();
//            else if (digitsSum(o1) < digitsSum(o2)) return -1;
//            else if (digitsSum(o1) > digitsSum(o2)) return 1;
//            else return o1.compareTo(o2);
//        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
}
