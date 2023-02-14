package Implementation;
import java.io.*;

//부녀회장이 될테야
public class p2775 {
    static int T;
    static public void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        //시간 복잡도를 계산 했을 때 배열을 모두 돌아도 괜찮..!
        //때문에 배열에 결과를 먼저 계산 후 입력에 따라 배열에서 출력 (dp이용x)

        int apartment[][] = new int[15][15];
        for(int i=1; i<15; i++){
            apartment[0][i] = i;
        }
        int sum=0;
        for(int i=1; i<15; i++){
            for(int j=1; j<15; j++){
                if(j==1){
                    apartment[i][j] = 1;
                }
                else{
                    for(int k=1; k<=j; k++){
                        sum += apartment[i-1][k];
                    }
                    apartment[i][j] = sum;
                }
                sum = 0;
            }
        }
        //T번 반복
        for(int count=0; count<T; count++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(apartment[k][n]);
        }
    }
}
