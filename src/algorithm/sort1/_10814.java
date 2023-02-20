package algorithm.sort1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10814 {
    public static int N;
    public static Member[] members = new Member[100001];
    public static Member[] tmp = new Member[100001];

    public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int left = st;
        int right = mid;

        for (int i = st; i < en; i++) {
            if (right == en) tmp[i] = members[left++];
            else if (left == mid) tmp[i] = members[right++];
            else if (members[left].age <= members[right].age)
                tmp[i] = members[left++];
            else tmp[i] = members[right++];
        }
        for (int i = st; i < en; i++) {
            members[i] = tmp[i];
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
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
//            members[i].age = age;
//            members[i].name = name;
            members[i] = new Member(age, name);
        }

        mergeSort(0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(members[i].age).append(' ').append(members[i].name).append('\n');
        }
        System.out.println(sb);

    }

    public static class Member {
        private final int age;
        private final String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
