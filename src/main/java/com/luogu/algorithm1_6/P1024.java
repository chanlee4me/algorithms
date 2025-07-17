package com.luogu.algorithm1_6;

import java.util.*;

public class P1024 {
    static double a, b, c, d;

    // 多项式值：(((a*x + b)*x + c)*x + d)
    static double f(double x) {
        return (((a * x) + b) * x + c) * x + d;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        d = sc.nextDouble();

        List<Double> roots = new ArrayList<>();
        final double eps = 1e-7;          // 二分精度
        final double delta = 1e-6;        // 判断 0 的阈值

        for (int i = -100; i < 100 && roots.size() < 3; i++) {
            double l = i, r = i + 1;
            double fl = f(l), fr = f(r);

            // 左端点就是根
            if (Math.abs(fl) < delta) {
                roots.add(l);
                continue;
            }

            // 区间内有根（异号）
            if (fl * fr < 0) {
                while (r - l > eps) {
                    double m = (l + r) / 2;
                    double fm = f(m);
                    if (fl * fm <= 0) {   // 根在 [l,m]
                        r = m;
                        fr = fm;
                    } else {              // 根在 [m,r]
                        l = m;
                        fl = fm;
                    }
                }
                roots.add((l + r) / 2);
            }
        }

        Collections.sort(roots);
        System.out.printf("%.2f %.2f %.2f%n", roots.get(0), roots.get(1), roots.get(2));
    }
}
