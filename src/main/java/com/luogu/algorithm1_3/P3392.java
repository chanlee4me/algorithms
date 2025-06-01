package com.luogu.algorithm1_3;

import java.util.*;

public class P3392 {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        Map<Integer, int[]> map = new HashMap<>();//key：i 行 value：每行的颜色情况 value[0] 红色个数 value[1]白色个数 value[2]蓝色个数
        for (int i = 0; i < n; i++) {
            map.put(i, new int[3]);
            String line = in.nextLine();
            for (char c : line.toCharArray()) {
                if (c == 'R') map.get(i)[0]++;
                if (c == 'W') map.get(i)[1]++;
                if (c == 'B') map.get(i)[2]++;
            }
        }
        /**
         * 涂n-2行的白 1行蓝 1行红
         * 涂n-1行的白 2行蓝 1行红
         * 涂n-3行的白 3行蓝 1行红
         * (1 -> n-2)白 (n - 2 -> 1)蓝 1
         */
        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {//前 i 行涂白
            //统计前 i 行需要涂的非白色的块数
            int whiteBlockNum = 0;
            for (int x = 0; x < i; x++) {
                whiteBlockNum += map.get(x)[1];
            }
            int whiteCost = i * m - whiteBlockNum;
            for (int j = 1; j <=  n - i - 1; j++) { //中间 j 行涂蓝
                //统计中间 j 行需要涂的非蓝色的块数
                int blueBlockNum = 0;
                for (int y = 0; y < j; y++) {
                    blueBlockNum += map.get(i + y)[2];
                }
                int blueCost = j * m - blueBlockNum;
                int k = n - i - j;//末尾 k 行涂红
                int redBlockNum = 0;
                for (int q = 0; q < k; q++) {
                    redBlockNum += map.get(i + j + q)[0];
                }
                int redCost = k * m - redBlockNum;
                int curCount = blueCost + redCost + whiteCost;
                minCount = Math.min(curCount, minCount);
            }
        }
        System.out.print(minCount);
    }

}