package com.luogu.algorithm1_2;

import java.math.BigInteger;
import java.util.*;

public class P1781 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int candidate = 1;
        in.nextLine();
        BigInteger voteNum = new BigInteger(in.nextLine());
        for (int i = 1; i < n; i++) {
            BigInteger curVoteNum = new BigInteger(in.nextLine());
            if(curVoteNum.compareTo(voteNum) > 0){
                candidate = i + 1;
                voteNum = curVoteNum;
            }
        }
        System.out.println(candidate);
        System.out.print(voteNum);
    }
}
