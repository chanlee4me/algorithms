package com.meituan;

import java.util.Scanner;

//2024年春招-美团-技术岗-第一批笔试-第三题
// 耗时4分钟，通过：ALL
public class P3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        in.nextLine();
        String s = in.nextLine();
        // 初始字符串中M、T的总数
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == 'M' || c == 'T'){
                count++;
            }
        }
        // 可以被修改的非 M、T字符总数
        int modifyCount = n - count;
        if(k < modifyCount){
            count += k;
            System.out.println(count);
        }else{
            System.out.println(n);
        }
    }
}
