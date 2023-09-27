package Graph;
import java.util.*;
import java.io.*;

//헌내기는 친구가 필요해

class Location21736{
    int x;
    int y;
    Location21736(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class p21736 {
    static int people=0;
    static int N, M;
    static char[][] map;
    static boolean[][] visited;

    static void findPeopleWithBFS(int startX, int startY){
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Location21736> queue = new LinkedList<>();
        visited[startX][startY] =true;
        queue.add(new Location21736(startX, startY));
        while (!queue.isEmpty()){
            Location21736 location = queue.poll();
            for(int i=0; i<4; i++){
                int x = location.x + dx[i];
                int y = location.y + dy[i];
                if(0<=x && x<N && 0<=y && y<M){
                    if(!visited[x][y] && map[x][y] != 'X'){
                        visited[x][y]= true;
                        if(map[x][y] == 'P'){
                            people ++;
                        }
                        queue.add((new Location21736(x, y)));
                    }
                }

            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        int startX=0, startY=0;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), "");
            String str = st.nextToken();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'I'){
                    startX = i;
                    startY = j;
                }
            }
        }
        findPeopleWithBFS(startX, startY);
        if(people == 0){
            System.out.print("TT");
        }
        else{
            System.out.print(people);
        }
    }
}
