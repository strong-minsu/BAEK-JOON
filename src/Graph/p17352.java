package Graph;

import java.io.*;
import java.util.*;

//여러분의 다리가 되어 드리겠습니다!
public class p17352 {
    static int N;
    static int[] parent;
    static int findParent(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if (a != b) {
            if(a < b) parent[b] = a;
            else parent[a] = b;
        }

    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N-2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            unionParent(a, b);
        }

        for (int i = 2; i <= N; i++) {
            if(findParent(1) != findParent(i)){
                System.out.print(1 + " " + i);
                return;
            }
        }
    }
}
