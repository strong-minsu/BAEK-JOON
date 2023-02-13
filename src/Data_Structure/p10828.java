package Data_Structure;
import java.io.*;
import java.util.*;

public class p10828 {
    static int number;
    public static void main(String[] args)throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        number = Integer.parseInt(st.nextToken());
//        System.out.println(number);
        String s;
        int n;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<number; i++){
            st = new StringTokenizer(br.readLine()," ");
            s = st.nextToken();

            if (s.equals("push")){
                n = Integer.parseInt(st.nextToken());
                stack.push(n);
            }
            else if (s.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.pop());
                }
            }
            else if (s.equals("size")) {
                System.out.println(stack.size());
            }
            else if (s.equals("empty")){
                if(stack.empty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            //else if(s == "top")
            else {
                if(stack.empty()){
                    System.out.println(-1);
                }
                else{
                    System.out.println(stack.peek());
                }
            }
        }

    }
}
