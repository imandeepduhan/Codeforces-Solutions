/*
Problem Name : 334-A Candy Bags.
Problem Link : https://codeforces.com/contest/334/problem/A

My Approach : I take half = n/2 because I print two numbers at a time (one from start and from end). 
I move start forward and end backward to print numbers in good order.
*/

import java.util.Scanner;
 
public class CandyBags {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int half = n / 2;
        int excution = n;
        int st = 1;
        int last = n * n;
 
        while (st < last && excution > 0) {
            int printNumbers = half;
            while (printNumbers > 0) {
                System.out.print(st + " " + last + " ");
                last--;
                st++;
                printNumbers--;
            }
            System.out.println();
            excution--;
        }
    }
}
