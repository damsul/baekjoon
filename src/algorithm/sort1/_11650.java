package algorithm.sort1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class _11650 {
    public static int N;
    public static Point[] points = new Point[100001];
    public static Point[] tmp = new Point[100001];

    public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int left = st;
        int right = mid;

        for (int i = st; i < en; i++) {
            if (right == en) tmp[i] = points[left++];
            else if (left == mid) tmp[i] = points[right++];
            else if (points[left].x < points[right].x) tmp[i] = points[left++];
            else if (points[left].x == points[right].x) {
                if (points[left].y <= points[right].y) tmp[i] = points[left++];
                else tmp[i] = points[right++];
            }
            else tmp[i] = points[right++];
        }
        for (int i = st; i < en; i++) {
            points[i] = tmp[i];
        }
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

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        mergeSort(0, N); // 얘가 더 빠름
//        Arrays.sort(points, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(points[i].x).append(' ').append(points[i].y).append('\n');
        }
        System.out.println(sb);
    }

}

class Point implements Comparable<Point>{
   int x;
   int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return this.y - o.y; // x가 같다면 y를 기준으로 오름차순 정렬
        return this.x - o.x; // x를 기준으로 오름차순 정렬
    }
}