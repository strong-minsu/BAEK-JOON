package Data_Structure;
import java.io.*;
import java.util.*;

public class p10845 {
    static int number;
    public static void main(String[] args)throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        number = Integer.parseInt(st.nextToken());
//        System.out.println(number);
        String s;
        int n;
        int last=0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<number; i++){
            st = new StringTokenizer(br.readLine()," ");
            s = st.nextToken();

            if (s.equals("push")){
                n = Integer.parseInt(st.nextToken());
                last = n;
                queue.add(n);
            }
            else if (s.equals("pop")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(queue.poll());
                }
            }
            else if (s.equals("size")) {
                System.out.println(queue.size());
            }
            else if (s.equals("empty")){
                if(queue.isEmpty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            else if (s.equals("front")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(queue.peek());
                }
            }
            else if (s.equals("back")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(last);
                }
            }
        }

    }
}
