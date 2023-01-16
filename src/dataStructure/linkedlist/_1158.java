package dataStructure.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        while (!list.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int a = list.removeFirst();
                list.addLast(a);
            }
            int b = list.removeFirst();
            list2.add(b);
        }

        System.out.print("<");
        for (int i = 0; i < n; i++) {
            System.out.print(list2.removeFirst());
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
}
