package Bruteforcing;

//셀프 넘버
public class p4673 {
    static int []self_number;
    static int brute_force (int n){
        int noself = n;

        while (n != 0){ //n이 0이 아닐때까지 반복
            noself = noself + (n % 10); // 첫 째 자리수
            n = n/10;	// 10을 나누어 첫 째 자리를 없앤다
        }

        return noself;
    }
    public static void main (String[] args){
        StringBuilder sb = new StringBuilder();
        self_number = new int [10001];

        for(int i=1; i<self_number.length; i++){
            int number = brute_force(i);
            if(number<10001) { //10000보다 작거나 같은 수만 필요
                self_number[number] = 1;
            }
        }

        for(int i=1; i<self_number.length; i++){
            if(self_number[i] == 0){
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
