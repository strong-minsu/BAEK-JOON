package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//달팽이는 올라가고 싶다
public class p2869 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Day;
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        V = V-A;
        if(V%(A-B) == 0){
            Day = V/(A-B) +1;
        }
        else{
            Day = V/(A-B) +2;
        }
        System.out.print(Day);
    }
}
