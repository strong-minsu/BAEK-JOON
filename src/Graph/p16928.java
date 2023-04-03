package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//뱀과 사다리 게임
public class p16928 {
    static int game_bord[];
    static boolean check[];
    static int result[];

    static void Search(){
        Queue<Integer> queue = new LinkedList<>();
        int start=1;
        queue.add(start);
        check[1] = true;

        while (!queue.isEmpty()){
            int current = queue.remove();
            if(current == 100){
                //100에 도착한 경우 리턴
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int next = current + i;
                if(next <= 100){
                    if(!check[next]){
                        check[next] = true;

                        if(game_bord[next] != 0){
                            //사다리와 뱀이 있는 경우 (사다리와 뱀을 통해 이동)
                            if(!check[game_bord[next]]){
                                queue.add(game_bord[next]);
                                check[game_bord[next]] = true;
                                result[game_bord[next]] = result[current]+1;
                            }
                        }
                        else{
                            //아무것도 없는 칸일 경우  (주사위로 이동)
                            result[next] =  result[current]+1;
                            queue.add(next);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        game_bord = new int[101];
        check = new boolean[101];
        result = new int[101];

        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            game_bord[n1] = n2;
        }
        Search();
        System.out.print(result[100]);
    }
}
