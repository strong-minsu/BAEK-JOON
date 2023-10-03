package Graph;

import java.util.*;
import java.io.*;

//촌수계산
public class p2644 {

    static LinkedList<Integer>[] Graph;
    static int n;
    static int X, Y;

    static int result = -1;

    static void graphLinkedList(int v){
        Graph = new LinkedList[v+1];
        for (int i=1; i<v+1; i++){
            Graph[i] = new LinkedList<>();
        }
    }

    public static void addEdge(int v1, int v2){
        Graph[v1].add(v2);
        Graph[v2].add(v1);
    }

    public static void findFamilyNumberWithBFS(){
        Queue<Integer> queue = new LinkedList<>();
        boolean []visited = new boolean[n + 1];
        int [] familyNumber= new int[n + 1];
        visited[X] = true;
        familyNumber[X]= 0;
        queue.add(X);

        while (!queue.isEmpty()){

            int node  = queue.poll();

            if (node == Y) {
                result = familyNumber[node];
                return;
            }

            for (int i = 0; i < Graph[node].size(); i++) {
                int g_node = Graph[node].get(i);

                if (!visited[g_node]) {
                    visited[g_node] = true;
                    familyNumber[g_node] = familyNumber[node] +1;
                    queue.add(g_node);
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st =new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        graphLinkedList(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            addEdge(v1, v2);
        }

        findFamilyNumberWithBFS();
        System.out.print(result);
    }
}
