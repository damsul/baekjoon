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
    // e1(1, 1)이고 e2(1, -1)이라고 했을 때 e1.x=1과 e2.x=1로 같다.
    // 따라서 e1.y=1과 e2.y=-1을 비교한다. => return e1.y - e2.y; => 2로 양수이므로 두 원소의 위치를 교환한다.

    // e1(2, 2)이고 e2(3, 3)이라고 했을 때 e1.x=2과 e2.x=3으로 같지 않다.
    // => return e1.x - e2.x; => -1로 음수이므로 두 원소의 위치를 교환하지 않는다.
}