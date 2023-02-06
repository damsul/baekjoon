package dataStructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class _5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String[] p;
        int n;
        String str;

        while (T-- > 0) {
            p = br.readLine().split("");
            n = Integer.parseInt(br.readLine());
            str = br.readLine();
            String[] data = str.substring(1, str.length() - 1).split(",");
            LinkedList<String> deque = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                deque.addLast(data[i]);
            }

            boolean isError = false;
            boolean isReverse = false;
            for (int i = 0; i < p.length; i++) {
                String command = p[i];
                switch (command) {
                    case "R":
                        if (isReverse) {
                            isReverse = false;
                        } else {
                            isReverse = true;
                        }
                        break;
                    case "D":
                        if (deque.isEmpty()) {
                            isError = true;
                            break;
                        }
                        if (isReverse) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                        break;
                }
            }

            if (!isError) {
                sb.append("[");
                if (!isReverse) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollFirst());
                        if (deque.size() > 0) {
                            sb.append(",");
                        }
                    }
                    sb.append("]\n");
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                        if (deque.size() > 0) {
                            sb.append(",");
                        }
                    }
                    sb.append("]\n");
                }

            } else {
                sb.append("error").append("\n");
            }
        }

        System.out.println(sb);
    }

}
