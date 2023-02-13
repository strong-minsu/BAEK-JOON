package Implementation;

public class p4673 {
    static int []self_number;
    static void d (){
        int n=1;
        int noself;
        while (n <= 10000){
            noself = n + (n/1000) + (n/100) + (n/10) + (n%10);
//            System.out.println(noself);
            if(noself<10001)
                self_number[noself] = 1;
            n++;
        }
    }
    public static void main (String[] args){
        StringBuilder sb = new StringBuilder();
        self_number = new int [100001];
        int n=1;
        int noself;
        d();
        for(int i=1; i<self_number.length; i++){
            if(self_number[i] == 1) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
