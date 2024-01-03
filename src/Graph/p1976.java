package Graph;

import java.io.*;
import java.util.*;

//여행 가자
// 그래프에 추가하긴 했지만, 분리 집합  (Union-find)알고리즘
public class p1976 {
    static int[] root;
    static int N, M;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        root = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            root[i] = i;
        }

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                int i_j = Integer.parseInt(st.nextToken());
                if(i_j == 1){
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int FirstPlan = Integer.parseInt(st.nextToken());
        boolean flag = true;
        for (int i = 1; i < M; i++) {
            if(root[FirstPlan] != root[Integer.parseInt(st.nextToken())]){
                flag = false;
                break;
            }
        }

        if(flag){
            System.out.print("YES");
        }
        else{
            System.out.print("NO");
        }
    }

    static int find(int index){
        if(root[index] == index){
            return index;
        }
        root[index] = find(root[index]);
        return root[index];
    }

    static void union(int x, int y){
        int Xroot = find(x);
        int Yroot = find(y);

        if(Xroot < Yroot){
            root[Yroot] = Xroot;
        }
        else{
            root[Xroot] = Yroot;
        }
    }
}
