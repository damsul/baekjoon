package dataStructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10866 {

    public static int[] q = new int[10001];
    public static int head = 0;
    public static int tail = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > -0) {
            String[] data = br.readLine().split(" ");
            String command = data[0];
            int x;

            switch (command) {
                case "push_front":
                    x = Integer.parseInt(data[1]);
                    push_front(x);
                    break;
                case "push_back":
                    x = Integer.parseInt(data[1]);
                    push_back(x);
                    break;
                case "pop_front":
                    sb.append(pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(pop_back()).append("\n");
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

    public static void push_front(int x) {
        for (int i = tail; i > head; i--) {
            q[i] = q[i - 1];
        }
        q[head] = x;
        tail++;
    }

    public static void push_back(int x) {
        q[tail++] = x;
    }

    public static int pop_front() {
        if (head == tail) {
            return -1;
        }
        return q[head++];
    }

    public static int pop_back() {
        if (head == tail) {
            return -1;
        }
        return q[tail-- - 1];
    }

    public static int size() {
        return tail - head;
    }

    public static int empty() {
        if (head == tail) {
            return 1;
        }
        return 0;
    }

    public static int front() {
        if (head == tail) {
            return -1;
        }
        return q[head];
    }

    public static int back() {
        if (head == tail) {
            return -1;
        }
        return q[tail - 1];
    }

}
