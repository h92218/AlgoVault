import java.util.*;

public class Problem11399 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt(); //사람수
        sc.nextLine();
        String[] temptimes = sc.nextLine().split(" ");
        int[] times = Arrays.stream(temptimes)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        Arrays.sort(times); //오름차순 정렬
        
        int timeTotal = 0;
        for(int time : times){
            timeTotal += time * cnt;
            cnt -= 1;
        }
        System.out.println(timeTotal);
    }
}
