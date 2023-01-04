package algorithm.graghTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1260 {
    public static int n, m, v;
    public static int[][] edges;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        edges = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from][to] = 1;
            edges[to][from] = 1;
        }

        dfsByRecursive(v);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(v);

    }

    public static void dfsByRecursive(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i <= n; i++) {
            if (edges[v][i] == 1 && !visited[i]) {
                dfsByRecursive(i);
            }
        }
    }

    // stack 은 문제가 있음(해결 안됨)
    public static void dfsByStack(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        while (!stack.isEmpty()) {
            int data = stack.pop();
            for (int i = 1; i <= n; i++) {
                if (edges[data][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                    break;
                }
            }
            System.out.print(data + " ");
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int data = queue.poll();
            for (int i = 1; i <= n; i++) {
                if ((edges[data][i] == 1 && !visited[i])) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
            System.out.print(data + " ");
        }
    }
}
