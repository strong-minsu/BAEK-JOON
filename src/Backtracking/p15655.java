package Backtracking;

import java.io.*;
import java.util.*;

public class p15655 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visit;
    static int[] arr;
    static int[] input;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input); //1, 7, 8, 9

        visit = new boolean[n];
        arr = new int[m];
        //현재 깊이, 시작 인덱스
        dfs(0,0);
        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {
        //0 0
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        //start = 0, depth = 0
        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true; //vistit[0] = true;
                arr[depth] = input[i]; //arr[0] = 1;
                dfs(depth + 1,i);//dfs (1, 0)
                            /*//dfs (1, 0)
							visit[0] = true;이므로 if문 안들어감;
		    				i == 1 -> visit[1] = true; , arr[1] = 7  (arr[depth] = input[i])
							dfs(2, 1);
							depth(2) == m(2) -> 1, 7 출력 후 리턴
		    				// visit[1] = false;

							i == 2 -> visit[2] = true;, arr[1] = 8 (arr[depth] = input[i])
							dfs(2, 2);
							depth(2) == m(2) -> 1, 8 출력 후 리턴
				    		// visit[2] = false;

							i == 3 -> visit[3] = true;, arr[1] = 9 (arr[depth] = input[i])
							dfs(2, 3);
							depth(2) == m(2) -> 1, 9 출력 후 리턴
							// visit[3] = false;
							*/
                //visit[0] = false;

                //i==1
                //visit[i] = true; //visit[1] = true;
                //arr[depth] = input[i]; //arr[0] = 7;
                            /*//dfs (1, 1)
							visit[1] = true;이므로 if문 안들어감;
							i == 2 -> visit[2] = true;, arr[1] = 8 (arr[depth] = input[i])
							dfs(2, 2);
							depth(2) == m(2) -> 7, 8 출력 후 리턴
							// visit[2] = false;

							i == 3 -> visit[3] = true;, arr[1] = 9 (arr[depth] = input[i])
							dfs(2, 3);
							depth(2) == m(2) -> 7, 9 출력 후 리턴
							// visit[3] = false;
							*/
                //i==2
                //visit[i] = true; //visit[2] = true;
                //arr[depth] = input[i]; //arr[0] = 8;
                            /*//dfs (1, 2)
							visit[2] = true;이므로 if문 안들어감;
							i == 3 -> visit[3] = true;, arr[1] = 9 (arr[depth] = input[i])
							dfs(2, 3);
							depth(2) == m(2) -> 8, 9 출력 후 리턴
							// visit[3] = false;
			    			*/

                visit[i] = false;
            }
        }
    }
}