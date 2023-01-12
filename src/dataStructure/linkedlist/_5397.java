package dataStructure.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class _5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); //명령 횟수 입력

        while (n-- > 0) {
            LinkedList<String> list = new LinkedList<>();
            ListIterator<String> iter = list.listIterator(); // 커서 처음으로 초기화

            String str = br.readLine(); // 문자열 입력

            for (int i = 0; i < str.length(); i++) {
                String s = String.valueOf(str.charAt(i));
                if (s.equals("<")) {
                    if (iter.hasPrevious()) { //리스트에 이전 데이터가 존재하면 true 반환, 그렇지 않은 경우 false 반환
                        iter.previous(); // 	리스트의 이전 데이터를 반환, 리스트 내 커서 위치를 이전 방향으로 이동
                    }
                } else if (s.equals(">")) {
                    if (iter.hasNext()) { //리스트에 다음 데이터가 존재하면 true 반환, 그렇지 않은 경우 false 반환
                        iter.next(); // 리스트의 다음 데이터를 반환, 리스트 내 커서 위치를 다음 방향으로 이동
                    }
                } else if (s.equals("-")) {
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove(); // next(), previous()로 반환된 가장 최근 데이터를 리스트에서 삭제
                    }
                } else {
                    iter.add(s); // 리스트의 nextIndex() 위치에 e를 추가함.
                }
            }
            System.out.println(String.join("", list));
        }
    }
}
