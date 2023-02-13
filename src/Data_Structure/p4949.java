package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p4949 {
    static Stack<String> stack;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");


        String str = st.nextToken();
        while (!str.equals(".")){
            stack = new Stack<>();
            if(str.equals("(") || str.equals("[")){
                stack.add(str);
            }
            else{
                if(str.equals(")")){
                    if(stack.isEmpty()) {
                        sb.append("NO").append("\n");
                        break;
                    }
                    else{
                        String s = stack.peek();
                        if(s.equals("(")) {
                            continue;
                        }
                        else{
                            sb.append("NO").append("\n");
                            break;
                        }
                    }
                } else if (str.equals("]")) {

                }
            }
        }
    }
}
