package Data_Structure;

import java.io.*;
import java.util.*;

//집합의 표현
// 자료구조에 추가하긴 했지만, 분리 집합  (Union-find)알고리즘
public class p1717 {
    static int [] root;
    static int n, m;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        root = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            root[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int commend = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(commend == 0){
                union(a, b);
            }
            else if(commend == 1){
                if(find(a) == find(b)){
                    sb.append("YES\n");
                }
                else{
                    sb.append("NO\n");
                }
            }
            else {
                continue;
            }
        }

        System.out.print(sb);
    }
    static int find(int index){
        if(root[index] == index){
            return index;
        }

        //root[index]의 부모를 찾는
        root[index] = find(root[index]);
        return root[index];
    }

    static void union(int x, int y){
        int rootx = find(x);
        int rooty = find(y);
        //일반적인 합집합 연산은 작은 값을 부모로..합니다.
        if(rootx != rooty){
            if(rootx < rooty){
                root[rooty] = rootx;
            }
            else{
                root[rootx] = rooty;
            }
        }

    }
}
