package com.luogu;
import java.util.Scanner;

class B2005{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String c = in.nextLine();
        String l1 = "  " + c;
        String l2 = " " + c + c + c;
        String l3 = c + c + c + c + c;
        System.out.println(l1);
        System.out.println(l2);
        System.out.print(l3);
    }
}
