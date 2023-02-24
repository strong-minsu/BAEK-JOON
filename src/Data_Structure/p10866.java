package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//덱
public class p10866 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<>();

        String str;
        int number = 0;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");

            if(st.countTokens() == 2){
                str = st.nextToken();
                number = Integer.parseInt(st.nextToken());
            }
            else{
                str = st.nextToken();
            }

            if(str.equals("push_front")){
                deque.addFirst(number);
            }
            else if (str.equals("push_back")){
                deque.addLast(number);
            }
            else if (str.equals("pop_front")) {
               if(deque.isEmpty()){
                   sb.append(-1).append("\n");
               }else{
                   sb.append(deque.removeFirst()).append("\n");
               }
            }
            else if (str.equals("pop_back")) {
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.removeLast()).append("\n");
                }
            }
            else if(str.equals("size")){
                sb.append(deque.size()).append("\n");
            }
            else if(str.equals("empty")){
                if(deque.isEmpty()){
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }
            else if (str.equals("front")) {
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.peekFirst()).append("\n");
                }
            }
            else if (str.equals("back")) {
                if(deque.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
