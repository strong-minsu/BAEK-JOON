package Graph;

import java.io.*;
import java.util.*;

//별자리 만들기
public class p4386 {
    static int n;
    static int [] parent;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        parent = new int[n];

        location[] start = new location[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            start[i] = new location(x, y);
        }

        //거리 정보 담기
        List<Edge> graph = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                double distance = Math.sqrt(Math.pow(start[i].x - start[j].x, 2) + Math.pow(start[i].y - start[j].y, 2));
                graph.add(new Edge(distance, i, j)) ;
            }
        }

        Collections.sort(graph);

        double result = 0;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < graph.size(); i++) {
            int v1 = graph.get(i).v1;
            int v2 = graph.get(i).v2;
            if(findParent(v1) != findParent(v2)){
                unionParent(v1, v2);
                result += graph.get(i).distance;
            }
        }

        System.out.print(result);
    }


    static int findParent(int x){
        if(parent[x]== x)return x;
        return parent[x] = findParent(parent[x]);
    }
    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
        return ;
    }
    static class location{
        double x, y;
        location( double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        double distance;
        int v1, v2;
        Edge(double distance, int v1, int v2){
            this.distance = distance;
            this.v1 = v1;
            this.v2 = v2;
        }

        public int compareTo(Edge o){
            if(distance < o.distance){
                return -1;
            }
            return 1;
        }
    }
}
