import java.util.*;

public class Problem10817 {
    // 세 수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        Optional<Integer> num = Arrays.stream(nums)
                                .mapToInt(Integer::parseInt)
                                .boxed()
                                .sorted((a,b) -> b-a)
                                .skip(1)
                                .findFirst();

        System.out.println(num.get());
    }
}

//1. Comparator는 객체를 비교하는 인터페이스이다.
//2. Instream은 기본 데이터 타입인 int 를 다루는 스트림이므로 Comparator를 사용할 수 없다.
//3. 따라서 boxed()를 사용하여 IntStream을 Stream<Integer>로 변환한다.