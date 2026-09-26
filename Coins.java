/*
Problem Name : 58-B Coins
Problem Link : https://codeforces.com/contest/58/problem/B
My Approach : I start with the given number and print it first, then 
i repeatedly divide the number by its smallest factor greater than 1.
I continue this process until the number becomes 1.
*/

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");

        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    n = n / i;
                    break;
                }
            }
            if (n > 1)
                System.out.print(n + " ");
        }

        System.out.println(1);
    }
}
