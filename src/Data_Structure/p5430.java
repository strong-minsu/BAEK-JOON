package Data_Structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

//AC
public class p5430 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        String P;
        int n;
        int array[];

        for (int i = 0; i < T; i++) {
            P = br.readLine();
            n = Integer.parseInt(br.readLine());
            Deque<Integer> deq = new LinkedList<>();
            boolean check_error = false;
            boolean r = true;
            String x = br.readLine();

            if(n>0){
                int x_size = x.length();
                String S  = x.substring(1, x_size-1);

                StringTokenizer st = new StringTokenizer(S, ",");
                int st_count = st.countTokens();
                for (int j = 1; j <= st_count; j++) {
                    deq.add(Integer.parseInt(st.nextToken()));
                }
            }

            for (int j = 0; j < P.length(); j++) {
                char p = P.charAt(j);
                if(p == 'R'){
                    if(r){
                        r =false;
                    }
                    else{
                        r = true;
                    }
                }
                else {
                    if(deq.isEmpty()){
                        check_error = true;
                        break;
                    }
                    else{
                        if(r){
                            deq.removeFirst();
                        }else{
                            deq.removeLast();
                        }
                    }
                }
            }

            if(check_error){
                sb.append("error").append("\n");
            }
            else{
                int size =deq.size();
                sb.append("[");
                for (int j = 0; j < size; j++) {
                    if(r){
                        if(j!=size-1){
                            sb.append(deq.removeFirst()).append(",");
                        }else{
                            sb.append(deq.removeFirst());
                        }
                    }else{
                        if(j!=size-1){
                            sb.append(deq.removeLast()).append(",");
                        }else{
                            sb.append(deq.removeLast());
                        }
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.print(sb);
    }
}
