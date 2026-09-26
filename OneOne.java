/*
Problem Name : 2207-A 1-1
Problem Link : https://codeforces.com/contest/2207/problem/A
My Approach : First , I convert string into array , than I start a for loop i = 1 and 
end condition is : i < n - 1 and than declare three variables f , l , m when f == l == 1 change index i into 1 and 0 . 
same repeat and i find MinOne and MaxOne.

*/

import java.util.Scanner;
 
public class OneOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            int[] arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arr[i] = str.charAt(i) - '0';
            }
            for (int i = 1; i < n - 1; i++) {
                int f = arr[i - 1];
                int l = arr[i + 1];
                int m = arr[i];
                if (f == 1 && l == 1) {
                    if (m == 1) {
                        continue;
                    } else {
                        arr[i] = 1;
                    }
                }
            }
            int maxOne = 0;
            for (int k : arr) {
                if (k == 1) {
                    maxOne++;
                }
            }
            for (int i = 1; i < n - 1; i++) {
                int f = arr[i - 1];
                int l = arr[i + 1];
                int m = arr[i];
                if (f == 1 && l == 1) {
                    if (m == 0) {
                        continue;
                    } else {
                        arr[i] = 0;
                    }
                }
            }
            int minOne = 0;
            for (int k : arr) {
                if (k == 1) {
                    minOne++;
                }
            }
            System.out.print(minOne + " " + maxOne);
            System.out.println();
        }
    }
}
