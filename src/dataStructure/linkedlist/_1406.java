package dataStructure.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class _1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> list = new LinkedList<>();
        String str = br.readLine().toLowerCase(); // 문자열 입력
        for (String s : str.split("")) { // 연결리스트로 변환
            list.add(s);
        }

        int n = Integer.parseInt(br.readLine()); //명령 횟수 입력

        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        while (n-- > 0) {
            String[] temp = br.readLine().split(" "); // 명령어 담을 공간 생성 및 명령어 입력
            switch (temp[0]) {
                case "L":  // 명령어 판단
                    if (iterator.hasPrevious()) {
                        iterator.previous(); // 명령어 실행
                    }
                    break;
                case "D":
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    break;
                case "B":
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case "P":
                    String s = temp[1];
                    iterator.add(s);
                    break;
            }
        } // 명령어 종료

        System.out.println(String.join("", list)); // 문자 이어붙이기

    }
}
