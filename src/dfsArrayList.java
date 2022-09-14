import java.util.ArrayList;
import java.util.Scanner;

public class dfsArrayList {
    public static void main(String[] args) {
        int n = 5;
        int m = 4;

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            a[v1].add(v2);
            a[v2].add(v1);
        }
        Boolean[] visited = new Boolean[a.length];
        for(int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        dfs(a,visited,0);  //0자리는 시작정점으로 정할것을 넣자

    }

    public static void dfs(ArrayList<Integer>[] a ,Boolean[] visited, int v){
        if(visited[v]) return;

        System.out.println("v : " + v);
        visited[v] = true;

        for(int vv : a[v]){
            dfs(a,visited,vv);
        }
    }
}
