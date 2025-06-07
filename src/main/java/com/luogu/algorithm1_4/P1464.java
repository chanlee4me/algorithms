package com.luogu.algorithm1_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P1464 {
    static long[][][] dp = new long[21][21][21];
    static boolean[][][] checked = new boolean[21][21][21];
    public static long w (int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0) return 1;
        if(a > 20 || b > 20 || c > 20) return w(20,20,20);

        if(checked[a][b][c] != false) return dp[a][b][c];
        if(a < b && b < c){
            dp[a][b][c] = w(a,b,c - 1) + w(a, b - 1,c - 1) - w(a, b - 1, c);
        }else{
            dp[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
        }
        checked[a][b][c] = true;
        return dp[a][b][c];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;

            out.printf("w(%d, %d, %d) = %d%n", a, b, c, w(a, b, c));
        }
        out.flush();
    }
}
