package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _15654 {

    public static int N, M;
    public static int[] arr = new int[10];
    public static boolean[] visited = new boolean[10];
    public static List<Integer> list;

    public static StringBuilder sb = new StringBuilder();
    public static void func(int k) { // 현재 k개까지 수를 택했음.
        if (k == M) { // m개를 모두 택했으면
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' '); // arr에 기록해둔 인덱스에 대응되는 수를 출력
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) { // 0부터 n-1까지의 인덱스에 대해
            if (visited[i]) continue; // 아직 i가 사용되지 않았으면
            arr[k] = list.get(i); // k번째 인덱스를 list.get(i)로 정함
            visited[i] = true; // i를 사용되었다고 표시
            func(k + 1); // 다음 인덱스를 정하러 한 단계 더 들어감
            visited[i] = false; // k번째 인덱스를 list.get(i)로 정한 모든 경우에 대해 다 확인했으니 list.get(i)를 이제 사용되지않았다고 명시함.
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Comparator.naturalOrder()); // list --> int[] num : Arrays.sort(num)

        func(0);
        System.out.println(sb);
    }

}
