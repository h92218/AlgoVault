import java.util.Scanner;

public class Problem2606 {
    static int[][] map; //연결망
    static boolean[] isChecked; //체크여부
    static int computerCnt; //컴퓨터 개수
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        computerCnt = Integer.parseInt(sc.nextLine());
        int lineCnt = Integer.parseInt(sc.nextLine());
        isChecked = new boolean[computerCnt+1];
        map = new int[computerCnt+1][computerCnt+1];

        //map에 연결여부 넣기
        for(int i=1; i<=lineCnt; i++){
            String[] line = sc.nextLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            map[a][b] = map[b][a] = 1;
        }

        dfs(1);
        System.out.println(virusCnt);
    }

    static int virusCnt = 0;
    public static void dfs(int start){
        isChecked[start] = true;
        for(int i=1; i<=computerCnt; i++){
            if(map[start][i] == 1 && !isChecked[i]){ //방문한 적 없고 연결1이면
                virusCnt+=1;
                dfs(i);
            }
        }
    }
}
