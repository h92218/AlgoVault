import java.util.*;

public class Problem1806 {
    //부분합
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numsCount = sc.nextInt();
        int targetSum = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[numsCount];
        for(int i=0; i<numsCount; i++){
            nums[i] = sc.nextInt();
        }

        int end = 0;
        int start = 0;
        int sum = 0;
        int minLen = numsCount+1;
        //end 포인터를 오른쪽으로 옮기면 합이 증가
        //start 포인터를 오른쪽으로 옮기면 합이 감소
    
        while(end < numsCount){ //end 포인터가 배열 마지막부분까지 가도록
            if(sum < targetSum){ //합이 목표합보다 작은 경우 : end 포인터를 오른쪽으로 옮긴다.
                sum += nums[end++];
            }
            while(sum >= targetSum){//합이 목표합보다 크거나 같은 경우 : start 포인터를 오른쪽으로 옮긴다.
                sum -= nums[start++];
                minLen = Math.min(minLen, end-start+1);
            }
        }
        
        if(minLen == numsCount + 1){
            System.out.println(0);
        }else{
            System.out.println(minLen);
        }
    }
    
}
