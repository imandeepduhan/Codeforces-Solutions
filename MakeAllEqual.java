/*
Problem Name : 2001-A Make All Equal.
Problem Link : https://codeforces.com/contest/2001/problem/A

My Approach : I count frequency of each number using an array. 
Then I find the number that appears maximum times. 
The answer is total elements minus the maximum frequency.
*/

import java.util.Scanner;
 
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[101];
            for (int i = 1; i <= n; i++) {
                int num = sc.nextInt();
                arr[num]++;
            }
            int idx = 1;
            for (int i = 1; i <= 100; i++) {
                if (arr[i] > arr[idx]) {
                    idx = i;
                }
            }
            System.out.println(n - arr[idx]);
        }
    }
}
