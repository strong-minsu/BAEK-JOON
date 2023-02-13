package Implementation;
import java.io.*;

public class p1259 {
    static public void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String number = br.readLine();
        while(!number.equals("0")){
            boolean b = true;
            int num_len = number.length();
            for(int i=0; i<num_len/2; i++) {
                if (number.charAt(i) == number.charAt(num_len - i - 1)) {
                    continue;
                } else {
                    b = false;
                }
            }
            if(b){
                sb.append("yes").append("\n");
            }
            else {
                sb.append("no").append("\n");
            }
            number = br.readLine();
        }
        System.out.print(sb);
    }
}
