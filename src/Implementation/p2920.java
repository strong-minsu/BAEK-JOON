package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//음계
public class p2920 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = "1 2 3 4 5 6 7 8";
        String d = "8 7 6 5 4 3 2 1";

        String play = br.readLine();
        if(play.equals(a)){
            System.out.print("ascending");
        }
        else if (play.equals(d)) {
            System.out.print("descending");
        }
        else{
            System.out.print("mixed");
        }
    }
}
