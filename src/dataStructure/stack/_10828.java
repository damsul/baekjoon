package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class _10828 {
    public static LinkedList<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        stack = new LinkedList<>();

        while (n-- > 0) {
            String[] arr = br.readLine().split(" ");
            String command = arr[0];

            switch (command) {
                case "push":
                    int x = Integer.parseInt(arr[1]);
                    push(x);
                    break;
                case "pop":
//                    System.out.println(pop());
                    sb.append(pop()).append("\n");
                    break;
                case "size":
//                    System.out.println(size());
                    sb.append(size()).append("\n");
                    break;
                case "empty":
//                    System.out.println(empty());
                    sb.append(empty()).append("\n");
                    break;
                case "top":
//                    System.out.println(top());
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    private static void push(int x) {
        stack.addLast(x);
    }

    private static int pop() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.removeLast();
        }
    }

    private static int size() {
        return stack.size();
    }

    private static int empty() {
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    private static int top() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.getLast();
        }
    }

}
