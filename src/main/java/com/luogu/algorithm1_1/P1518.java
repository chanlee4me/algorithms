package com.luogu.algorithm1_1;

import java.util.Arrays;
import java.util.Scanner;

public class P1518 {
    static int[] cowStart = new int[2];//0:row 1:col
    static int[] manStart = new int[2];
    static char[][] map = new char[12][12];
    static int[] cowCurPos = new int[]{cowStart[0], cowStart[1]};
    static int[] manCurPos = new int[]{manStart[0], manStart[1]};
    static int timeCount = 0;
    // 定义方向常量，更清晰
    static final int NORTH = 0; // 北
    static final int EAST = 1;  // 东
    static final int SOUTH = 2; // 南
    static final int WEST = 3;  // 西
    static int cowDirect = NORTH;//北：0 东：1 南：2 西：3
    static int manDirect = NORTH;
    public static void main(String[] args) {
        //init map
        Scanner in = new Scanner(System.in);
        for(int i = 1; i <= 10; i++){
            String s = in.nextLine();
            for (int j = 1; j <= 10; j++) {
                map[i][j] = s.charAt(j - 1);
                if(map[i][j] == 'C'){
                    cowCurPos[0] = cowStart[0] = i;
                    cowCurPos[1] = cowStart[1] = j;
                }else if(map[i][j] == 'F'){
                    manCurPos[0] = manStart[0] = i;
                    manCurPos[1] = manStart[1] = j;
                }
            }
        }
        for (int i = 0; i < 12; i++) {
            map[i][0] = '*';
            map[i][11] = '*';
        }
        for (int i = 0; i < 12; i++) {
            map[0][i] = '*';
            map[11][i] = '*';
        }
        do{
            if(isMeet()){
                System.out.print(timeCount);
                return;
            }
            timeCount++;
            move(0);
            move(1);
        }while (isValid());
        System.out.print(0);
    }

    private static void move(int type){
        if(type == 0){//人
            if(manDirect == NORTH){
                if(map[manCurPos[0] - 1][manCurPos[1]] == '*') manDirect = EAST;
                else manCurPos[0] -= 1;
            }
            else if(manDirect == EAST){
                if(map[manCurPos[0]][manCurPos[1] + 1] == '*') manDirect = SOUTH;
                else manCurPos[1] += 1;
            }
            else if(manDirect == SOUTH){
                if(map[manCurPos[0] + 1][manCurPos[1]] == '*') manDirect = WEST;
                else manCurPos[0] += 1;
            }
            else if(manDirect == WEST){
                if(map[manCurPos[0]][manCurPos[1] - 1] == '*') manDirect = NORTH;
                else manCurPos[1] -= 1;
            }
        }
        if(type == 1){//牛
            if(cowDirect == NORTH){
                if(map[cowCurPos[0] - 1][cowCurPos[1]] == '*') cowDirect = EAST;
                else cowCurPos[0] -= 1;
            }
            else if(cowDirect == EAST){
                if(map[cowCurPos[0]][cowCurPos[1] + 1] == '*') cowDirect = SOUTH;
                else cowCurPos[1] += 1;
            }
            else if(cowDirect == SOUTH){
                if(map[cowCurPos[0] + 1][cowCurPos[1]] == '*') cowDirect = WEST;
                else cowCurPos[0] += 1;
            }
            else if(cowDirect == WEST){
                if(map[cowCurPos[0]][cowCurPos[1] - 1] == '*') cowDirect = NORTH;
                else cowCurPos[1] -= 1;
            }
        }
    }
    private static boolean isMeet(){
        return Arrays.equals(cowCurPos, manCurPos);
    }
    //要限制最大步数——人类可能的走法一共是 4*10*10，牛也一样，因此一共最多走 400*400步
    private static boolean isValid() {
        return timeCount <= 160000;
    }
}

