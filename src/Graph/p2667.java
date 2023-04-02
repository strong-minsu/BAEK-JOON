package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//단지번호붙이기
public class p2667 {
    static int N;
    static int[][] apartment;
    static boolean[][] check;
    static int count_house = 0;
    static int count_complex = 0;
    static void search (int x, int y) {
        apartment[y][x] = count_complex;
        check[y][x] = true;
        count_house++;

        int next[][] = {{x+1, y}, {x-1, y},
                {x, y+1}, {x, y-1}};
        for (int i = 0; i < 4; i++) {
            boolean range = next[i][0]>=0 && next[i][0]<N && next[i][1]>=0 &&next[i][1]<N;
            if(range && !check[next[i][1]][next[i][0]] && apartment[next[i][1]][next[i][0]] == 1){
                apartment[next[i][1]][next[i][0]] = count_complex;
                search(next[i][0], next[i][1]);
            }
        }
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        apartment = new int[N][N];
        check = new boolean[N][N];

        String str;

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < N; j++) {
                apartment[i][j] = str.charAt(j) - '0';
            }
        }

        PriorityQueue<Integer> count = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!check[i][j] && apartment[i][j] == 1){
                    count_complex++;
                    count_house = 0;
                    search(j, i);
                    count.add(count_house);
                }
            }
        }

        sb.append(count_complex).append("\n");
        for (int i = 0; i < count_complex; i++) {
            sb.append(count.remove()).append("\n");
        }

        System.out.print(sb);
    }
}
