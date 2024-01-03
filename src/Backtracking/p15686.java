package Backtracking;

import java.io.*;
import java.util.*;

//치킨 배달
public class p15686 {
    static int N, M;
    static boolean open[];
    static int Min = Integer.MAX_VALUE;

    static class Location15686 {
        int X, Y;
        Location15686(int X, int Y){
            this.X = X;
            this.Y = Y;
        }
    }
    static ArrayList<Location15686> home = new ArrayList<>();
    static ArrayList<Location15686> chicken = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1){
                    home.add(new Location15686(i, j));
                }
                else if(n == 2){
                    chicken.add(new Location15686(i, j));
                }
            }
        }

        open = new boolean[chicken.size()];

        dfs(0,0);
        System.out.print(Min);
    }
    static void dfs(int index, int depth){
        if(depth == M){ //치킨집 개수가 같아진 경우
            //거리 계산 후 Min 업데이트

            //현재 치킨집 조합에서 최종 거리
            int resultDistance=0;

            for (int i = 0; i < home.size(); i++) {
                //현재집에서 가장 가까운 치킨 거리
                int disctanceHomeToChicken = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    //조합에서 선택 된 치킨 집만 검사
                    if(open[j]){
                        int distance = Math.abs(home.get(i).X - chicken.get(j).X) + Math.abs(home.get(i).Y - chicken.get(j).Y);
                        disctanceHomeToChicken = Math.min(distance, disctanceHomeToChicken);
                    }
                }
                // 최종 거리에 현재 집에서 가장 가까운 치킨 거리 추가
                resultDistance += disctanceHomeToChicken;
            }

            Min = Math.min(Min, resultDistance);
        }

        for (int i = index; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i+1, depth+1);
            open[i] = false;
        }
    }
}


