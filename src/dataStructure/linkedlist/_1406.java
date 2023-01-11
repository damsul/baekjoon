package dataStructure.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class _1406 {

    public static LinkedList<String> list;
    public static int cursor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase(); // 문자열 입력
        list = new LinkedList<>();
        for (String s : str.split("")) { // 연결리스트로 변환
            list.add(s);
        }
        cursor = str.length(); // 커서 생성

        int n = Integer.parseInt(br.readLine()); //명령 횟수 입력

        while (n-- > 0) {
            String[] temp = br.readLine().split(" "); // 명령어 담을 공간 생성 및 명령어 입력
            if (temp[0].equals("L")) { // 명령어 판단
                moveLeft(); // 명령어 실행
            }
            if (temp[0].equals("D")) {
                moveRight();
            }
            if (temp[0].equals("B")) {
                delete();
            }
            if (temp[0].equals("P")) {
                String s = temp[1];
                insert(s);
            }
        } // 명령어 종료
        print(); //문자열 출력
    }

    private static void print() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }

    private static void insert(String s) {
        list.add(cursor, s);
        cursor++;
    }

    private static void delete() {
        if (cursor <= 0) {
            return;
        }
        list.remove(cursor - 1);
        cursor--;
    }

    private static void moveRight() {
        if (cursor >= list.size()) {
            return;
        }
        cursor++;
    }

    private static void moveLeft() {
        if (cursor <= 0) {
            return;
        }
        cursor--;
    }
}
