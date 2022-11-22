package Exam;

import java.util.Stack;

public class Exam {
    static final int MAX_N = 10;
    static boolean[] Visited = new boolean[MAX_N];
    static int N = 5, E = 6;
    static int[][] Graph = new int[MAX_N][MAX_N];

    public static void dfs(int n) {
        Visited[n] = true;
        System.out.println(n);

        for (int i = 0; i < N; ++i) {
            if (Graph[n][i] == 1 && !Visited[i])
                dfs(i);
        }
    }

    public static void dfsStack(int n) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(n);

        while(!myStack.isEmpty()) {
            int cur = myStack.pop();
            if (Visited[cur]) continue;

            Visited[cur] = true;
            System.out.println(n);

            for (int i = 0; i < N; ++i) {
                if (Graph[n][i] != 0 && !Visited[i])
                    myStack.push(i);
            }
        }
    }
}
