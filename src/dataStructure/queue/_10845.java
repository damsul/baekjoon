package dataStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class _10845 {

    public static Queue queue = new Queue();

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
                    queue.push(x);
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.empty()).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    sb.append(queue.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}

class Queue {

    LinkedList<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }

        return queue.removeFirst();
    }

    public int size() {
        return queue.size();
    }

    public int empty() {
        if (queue.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public int front() {
        if (queue.isEmpty()) {
            return -1;
        }

        return queue.getFirst();
    }

    public int back() {
        if (queue.isEmpty()) {
            return -1;
        }

        return queue.getLast();
    }
}


