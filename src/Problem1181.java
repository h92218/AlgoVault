import java.util.*;

public class Problem1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        String[] words = new String[cnt];
        for(int i=0; i<cnt; i++){
            words[i] = sc.nextLine();
        }

        String[] newWords = Arrays.stream(words)
                        .distinct()
                        .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(String::compareTo))
                        .toArray(String[]::new);

        for(String w : newWords){
            System.out.println(w);
        }
    }
    
}
