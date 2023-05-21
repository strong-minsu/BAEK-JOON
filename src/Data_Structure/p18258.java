package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//큐 2
public class p18258 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue2 = new LinkedList<>();
        String commend;
        int x = 0;
        int last=0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            commend = st.nextToken();

            if(commend.equals("push")){
                x = Integer.parseInt(st.nextToken());
                last = x;
                queue2.add(x);
            }
            else if(commend.equals("pop")){
                if(queue2.isEmpty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(queue2.remove()).append("\n");
                }
            }
            else if(commend.equals("size")){
                sb.append(queue2.size()).append("\n");
            }
            else if(commend.equals("empty")){
                if(queue2.isEmpty()){
                    sb.append(1).append("\n");;
                }
                else{
                    sb.append(0).append("\n");;
                }
            }
            else if(commend.equals("front")){
                //제거하는 것 아님!!
                if(queue2.isEmpty()){
                    sb.append(-1).append("\n");;
                }
                else {
                    sb.append(queue2.peek()).append("\n");
                }
            }
            else if(commend.equals("back")){
                //제거하는 것 아님!!
                if(queue2.isEmpty()){
                    System.out.println(-1);
                }
                else {
                    sb.append(last).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
