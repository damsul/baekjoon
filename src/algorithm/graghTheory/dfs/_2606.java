package algorithm.graghTheory.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2606 {

    public static boolean[] isVisited;
    public static int cnt;
    public static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        isVisited = new boolean[n + 1];
        cnt = 0;

        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int num) {
        isVisited[num] = true;

//        for (int i = 0; i < list.get(num).size(); i++) {
//            int x = list.get(num).get(i);
//            if (!isVisited[x]) {
//                cnt++;

//                dfs(x);
//            }
//        }

        for (int v : list.get(num)) {
            if (!isVisited[v]) {
                dfs(v);
                cnt++;
            }

        }

    }
}
