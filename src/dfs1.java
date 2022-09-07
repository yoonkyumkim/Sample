import java.util.Scanner;
import java.util.Stack;

public class dfs1 {

    static final int MAX_N = 10;
    static int N, E;
    static int[][] Graph = new int[MAX_N][MAX_N];
    static boolean[] Visited = new boolean[MAX_N];

    //input 5 6
    //0 1 0 2 1 3 1 4 2 4 3 4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        for (int i = 0; i < E; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            Graph[u][v] = Graph[v][u] = 1;
        }

    }

    static void dfs(int node) {
        Visited[node] = true;
        System.out.println(node + " ");

        for (int next = 0; next < N; ++next) {
            if (!Visited[next] && Graph[node][next] != 0)
                dfs(next);
        }
    }

    static void stackDfs(int node) {
        boolean[] visited = new boolean[MAX_N];
        Stack<Integer> mystack = new Stack<>();
        mystack.push(node);

        while (!mystack.empty()) {
            int curr = mystack.pop();

            if (visited[curr]) continue;

            visited[curr] = true;
            System.out.println(curr + " ");

            for (int next = 0; next < N; ++next) {
                if (!visited[next] && Graph[curr][next] != 0)
                    mystack.push(next);
            }
        }
    }


}
