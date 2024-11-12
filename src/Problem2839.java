import java.util.Scanner;

public class Problem2839{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int count5 = total/5;

        while(count5 >= 0){
            int remain = total - count5 * 5;
            if(remain % 3 == 0){
                System.out.println(count5 + remain/3);
                return;
            }
            count5 -= 1;
        }

        System.out.println(-1);

    }
}
