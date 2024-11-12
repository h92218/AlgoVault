import java.io.File;
import java.util.*;

public class Problem1202 {
    public static void main(String[] args) throws Exception {
        System.out.println(System.currentTimeMillis());
        //목적 최대한 비싼 보석 넣기
        Scanner sc = new Scanner(new File("D:\\study\\Baekjoon\\coding\\src\\1202.txt"));
        int jewelCnt = sc.nextInt();
        int bagCnt = sc.nextInt();

        //보석 무게와 가격 정보59ms 79ms
        /* 
        Jewelry[] jewels = new Jewelry[jewelCnt];
        for(int i=0; i<jewelCnt; i++){
            Jewelry temp = new Jewelry(sc.nextInt(), sc.nextInt());
            jewels[i] = temp;
        }
            */
            int[][] jewels = new int[jewelCnt][2];
            for(int i=0; i<jewelCnt; i++){ 
                int[] jew = {sc.nextInt(), sc.nextInt()};
                jewels[i] = jew;
            }

        //보석 무게 오름차순
        //Arrays.sort(jewels, Comparator.comparingInt(j -> j.mass));

        //보석 가격 내림차순
        //Arrays.sort(jewels,Comparator.comparingInt((int[] a)->a[1]).reversed());
        //보석 무게 오름차순
        Arrays.sort(jewels,Comparator.comparingInt((int[] a)->a[0]));


        //가방 정보
        int[] bagInfo = new int[bagCnt];
        for(int i=0; i<bagCnt; i++){
            bagInfo[i] = sc.nextInt();
        }
        //가방 무게 적은 순 정렬
        Arrays.sort(bagInfo);
        
        //가격 높은 순 정렬
        // int[][] sortedJewel = Arrays.stream(jewels)
        //                     .sorted(Comparator.comparingInt((int[] a)->a[1]).reversed())
        //                     .toArray(int[][]::new);
        

        
        long sum = 0;
        // for(int weight : bagInfo){
        //     for(int i=0; i<jewels.length; i++){
        //         if(jewels[i][0] != -1 && weight >= jewels[i][0] ){
        //             sum+=jewels[i][1];
        //             jewels[i][0] = -1;
        //             break;
        //         }
        //     }
        // }
        int jewelIndex = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int bag : bagInfo) {
            // 현재 가방 무게에 맞는 모든 보석을 추가
            while (jewelIndex < jewels.length && jewels[jewelIndex][0] <= bag) {
                pq.offer(jewels[jewelIndex][1]);
                jewelIndex++;
            }
            // 가장 비싼 보석 선택
            if (!pq.isEmpty()) {
                sum += pq.poll(); // 선택된 보석은 다른 가방에서 사용되지 않음
            }
        }
        
        System.out.println(sum);
        System.out.println(System.currentTimeMillis());
    } 
}

class Jewelry {
    int mass; // 무게
    int price; // 가격
 
    Jewelry(int mass, int price) {
        this.mass = mass;
        this.price = price;
    }
}
