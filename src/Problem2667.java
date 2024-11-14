import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Problem2667 {
    static boolean[][] isChecked; //체크여부
    static int[][] map;           //지도
    static int mapSize;           //지도의 크기
    static Deque<int[]> queue = new ArrayDeque<>();   //방문할 좌표
    static int[] xmove = new int[]{-1, 1, 0, 0};           //상하좌우
    static int[] ymove = new int[]{0, 0, -1, 1};           //상하좌우
    static int townCnt = 0;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("D:\\study\\Baekjoon\\coding\\src\\2667.txt"));
        mapSize = Integer.parseInt(sc.nextLine());
        map = new int[mapSize][mapSize];
        isChecked = new boolean[mapSize][mapSize];

        //map 저장
        for(int i=0; i<mapSize; i++){
            String row = sc.nextLine();
            for(int j=0; j<row.length(); j++){
                map[i][j] = row.charAt(j) - '0';
            }
        }

        for(int i=0; i<mapSize; i++){
            for(int j=0; j<mapSize; j++){
                if(!isChecked[i][j] && map[i][j] == 1){ //방문체크 안되어있는 1값인 경우 시작
                    townCnt += 1; //단지 카운트
                    bfs(i, j);
                }
            }
        }
        System.out.println(townCnt);
        Collections.sort(townSizes);
        for(Integer cnt : townSizes){
            System.out.println(cnt);
        }
    }
    static List<Integer> townSizes = new ArrayList<>();
    public static void bfs(int x, int y){
        int townSize = 1;
        queue.add(new int[]{x, y});
        isChecked[x][y] = true;
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            for(int i=0; i<4; i++){
                int newx = position[0] + xmove[i];
                int newy = position[1] + ymove[i];
                if(newx >= 0 && newy >= 0 && newx < mapSize && newy < mapSize
                    && map[newx][newy] == 1
                    && !isChecked[newx][newy]
                ){
                    queue.add(new int[]{newx, newy});
                    isChecked[newx][newy] = true;
                    townSize += 1;
                }
            }
        }

        townSizes.add(townSize);    
        
    }
}
