package com.luogu.algorithm1_4;

import java.util.*;

public class P1928 {
    public static void main(String[] args) {
        /**
         * 本题有个 trick：在进入下一层之前，就算当前字母字符串或者数字字符串为空，也要入栈
         */
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Deque<StringBuilder> numStack = new LinkedList<>();//保存每一层的重复次数
        Deque<StringBuilder> letterStack = new LinkedList<>();//保存每一层的字符串
        StringBuilder numStr = new StringBuilder();//当前层的数字
        StringBuilder letterStr = new StringBuilder();//当前层的字符串
        for (char c : line.toCharArray()){
            if(Character.isDigit(c)){
                numStr.append(c);
            }else if(Character.isAlphabetic(c)){
                letterStr.append(c);
            } else if (c == '[') {
//                进入下一层之前，把当前层压栈并重置当前层
                numStack.addLast(numStr);
                letterStack.addLast(letterStr);
                numStr = new StringBuilder("");
                letterStr = new StringBuilder("");
            }else{//']'
                //先将本层重复
                StringBuilder temp1 = new StringBuilder();
                if(!numStr.isEmpty()){
                    for (int i = 0; i < Integer.parseInt(numStr.toString()); i++) {
                        temp1.append(letterStr);
                    }
                }
                if(!temp1.isEmpty())
                    letterStr = temp1;
                //再和上一层字符串拼接
                StringBuilder temp = new StringBuilder(letterStack.removeLast());//上层已积累的字符串
                letterStr = temp.append(letterStr);
                //更新当前层的重复次数
                numStr = numStack.removeLast();
            }
        }
        System.out.println(letterStr);
    }
}
