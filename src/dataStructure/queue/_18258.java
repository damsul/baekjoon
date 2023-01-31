package dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _18258 {
    public static int[] queue = new int[2000001];
    public static int head = 0;
    public static int tail = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            String[] data = br.readLine().split(" ");
            String command = data[0];

            switch (command) {
                case "push":
                    int x = Integer.parseInt(data[1]);
                    push(x);
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int x) {
        queue[tail++] = x;
    }

    public static int pop() {
        if (tail - head == 0) {
            return -1;
        } else {
            return queue[head++];
        }
    }

    public static int size() {
        return tail - head;
    }

    public static int empty() {
        if (tail - head == 0) {
            return 1;
        }
        return 0;
    }

    public static int front() {
        if (tail - head == 0) {
            return -1;
        }
        return queue[head];
    }

    public static int back() {
        if (tail - head == 0) {
            return -1;
        }
        return queue[tail - 1];
    }

}
