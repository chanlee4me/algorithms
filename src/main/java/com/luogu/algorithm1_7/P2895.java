package com.luogu.algorithm1_7;

import java.util.*;

public class P2895 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();

        // 记录该位置被摧毁的最快时间
        int[][] destroyTime = new int[301][301];
        for (int i = 0; i < destroyTime.length - 1; i++) {
            Arrays.fill(destroyTime[i], Integer.MAX_VALUE);
        }

        // 记录所有被摧毁的位置和时间
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int time = in.nextInt();
            // 当前位置
            destroyTime[x][y] = Math.min(destroyTime[x][y], time);
            // 四个相邻位置
            if(x > 0) destroyTime[x - 1][y] = Math.min(destroyTime[x - 1][y], time);
            if(x < destroyTime.length - 1) destroyTime[x + 1][y] = Math.min(destroyTime[x + 1][y], time);
            if(y > 0) destroyTime[x][y - 1] = Math.min(destroyTime[x][y - 1], time);
            if(y < destroyTime.length - 1) destroyTime[x][y + 1] = Math.min(destroyTime[x][y + 1], time);
        }

        // 记录主角当前所处的坐标
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        //记录当前所处时刻
        int time = 0;
        int res = -1;

        // 访问标记
        boolean[][] visited = new boolean[305][305];
        visited[0][0] = true;

        // 四个移动方向
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // bfs
        while(!queue.isEmpty()){
            int size = queue.size();
            int flag = -1;
            for (int i = 0; i < size; i++) {
                int[] curPos = queue.poll();
                int x = curPos[0];
                int y = curPos[1];
                //抵达安全位置：不会坠落流星且不会被周边流星摧毁
                if(destroyTime[x][y] == Integer.MAX_VALUE){
                    flag = 1;
                    res = time;
                    break;
                }
                //开始移动
                for(int[] dir : dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    int nt = time + 1;

                    //检查边界状态
                    if(nx >= 0 && ny >= 0 && !visited[nx][ny]){
                        //检查是否安全
                        if(destroyTime[nx][ny] > nt){
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx,ny});
                        }
                    }
                }

            }
            time++;
            if(flag == 1) break;
        }
        System.out.println(res);
    }


}
