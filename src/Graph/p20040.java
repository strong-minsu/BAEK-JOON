package Graph;

import java.util.*;
import java.io.*;

//사이클 게임
public class p20040 {
    static int n, m;
    static int[] parent;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int result = 0;

        for (int i = 1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            if(findParent(v1) == findParent(v2)){
                result = i;
                break;
            }
            else{
                unionParent(v1, v2);
            }
        }
        System.out.print(result);

    }
    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
        return;
    }
    static int findParent(int x){
        if(x == parent[x])return x;
        return parent[x] = findParent(parent[x]);
    }
}
