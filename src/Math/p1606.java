package Math;
import java.util.*;
import java.io.*;

//침투 계획 세우기
public class p1606 {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        long result = 1;

        //x == 0일 경우
        for (int i=1; i<=y ; i++) {
            result += (1+(6 * (i-1)));
        }

        System.out.print(result);

        for (int i=0; i<x ; i++) {
            result += 6*(y+i);
        }

        System.out.print(result);
    }
}
