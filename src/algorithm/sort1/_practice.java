package algorithm.sort1;

public class _practice {

    public static int n = 10;
    public static int[] arr = new int[10000001];
    public static int[] tmp = new int[10000001];

    public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int aidx = st;
        int bidx = mid;

        for (int i = st; i < en; i++) {
            if (bidx == en) tmp[i] = arr[aidx++];
            else if (aidx == mid) tmp[i] = arr[bidx++];
            else if (arr[aidx] <= arr[bidx]) tmp[i] = arr[aidx++];
            else tmp[i] = arr[bidx++];
        }
        for (int i = st; i < en; i++) {
            arr[i] = tmp[i];
        }
    }
    public static void mergeSort(int st, int en) {
        if(st + 1 == en) return;
        int mid = (st + en) / 2;
        mergeSort(st, mid);
        mergeSort(mid, en);
        merge(st, en);
    }

    public static void main(String[] args) {

        arr = new int[]{-7, 9, 1, 4, 6, -8, - 5, 10, 11, 0};

        mergeSort(0, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
