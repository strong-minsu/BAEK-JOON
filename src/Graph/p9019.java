package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//DSLR
public class p9019 {
    static String string;
    static void BFS(int A, int B) {
        boolean []visited = new boolean[10000];
        String count[] = new String[10000];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(A);
        count[A] = "";
        while (!queue.isEmpty()){
            int current = queue.remove();

            //방문하지 않았다면
            if(!visited[current]) {

                //방문한 상태로 저장
                visited[current] = true;

                //D, S, L, R된 4가지 수 저장
                int DSLR [] = new int[4];
                DSLR[0] = (current*2) % 10000;
                if(current == 0){
                    DSLR[1] = 9999;
                }
                else {
                    DSLR[1] = current-1;
                }
                String s = Integer.toString(current);
                int length = s.length();
                int temp = (int)Math.pow(10, length-1);

                int quotient = current/temp;
                int reminder = current%temp;
                DSLR[2] = reminder*10 + quotient;

                quotient = current/10;
                reminder = current%10;
                DSLR[3] = quotient*10 + reminder;

                String dslr = "DSLR";
                for(int j=0; j<4; j++) {
                    int n = DSLR[j];
                    //방문 안한 상태면 큐에 넣어줌
                    if(!visited[n]) {
                        queue.add(n);
                        count[n] = count[current] + Character.toString(dslr.charAt(j));
                        if (n == B){
                            string = count[n];
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int A = 0, B = 0;
        for (int i = 0; i < T; i++) {
            string ="";
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            BFS(A, B);
            System.out.println(string);
        }
    }
}
