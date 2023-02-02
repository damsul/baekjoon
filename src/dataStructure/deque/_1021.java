package dataStructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class _1021 {

    public static LinkedList<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 덱 크기
        int M = Integer.parseInt(s[1]); // 뽑으려는 숫자 개수

        for (int i = 1; i <= N; i++) { // N까지 덱 채우기
            deque.add(i);
        }

        int[] findNum = new int[M];
        s = br.readLine().split(" "); // 뽑으려는 숫자 입력
        for (int i = 0; i < M; i++) {
            findNum[i] = Integer.parseInt(s[i]);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int targetIdx = deque.indexOf(findNum[i]);
            int halfIdx = deque.size() / 2;

//            if (deque.size() % 2 == 0) {
//                halfIdx = deque.size() / 2 - 1;
//            } else {
//                halfIdx = deque.size() / 2;
//            }

            if (targetIdx <= halfIdx) {
                while (findNum[i] != deque.getFirst()) {
                    deque.addLast(deque.pollFirst());
                    cnt++;
                }
            } else {
                while (findNum[i] != deque.getFirst()) {
                    deque.addFirst(deque.pollLast());
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}
