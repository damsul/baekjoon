package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _17298 {

    public static void main(String[] args) throws IOException {
        // 3,5,2,7, -> 5,7,7,-1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && data[stack.peek()] < data[i]) {
                data[stack.pop()] = data[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            data[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : data) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);

    }

}
