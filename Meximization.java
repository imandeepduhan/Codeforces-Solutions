/*
Problem Name : 1497-A Meximization
Problem Link : https://codeforces.com/contest/1497/problem/A

My Approach : First I created an array of size 101. 
Then,a variable was created to store the largest number in the array. 
Then I created two lists ans or dup the ans list will store the sorted
elements and dup list store duplicate elements. Then I had the ans and dup lists printed.

*/

import java.util.ArrayList;
import java.util.Scanner;
 
public class Meximization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(); // no of elements
            int[] arr = new int[101];
            int maxEl = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                int temp = sc.nextInt();
                arr[temp]++;
                maxEl = Math.max(maxEl, temp);
            }
            ArrayList<Integer> ans = new ArrayList<>();
            ArrayList<Integer> dup = new ArrayList<>();
            for (int i = 0; i <= maxEl; i++) {
                if (arr[i] == 1) {
                    ans.add(i);
                } else {
                    if (arr[i] > 1) {
                        ans.add(i);
                        arr[i]--;
                    }
                    while (arr[i] != 0) {
                        dup.add(i);
                        arr[i]--;
                    }
                }
            }
 
            for (int a : ans) {
                System.out.print(a + " ");
            }
            for (int b : dup) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
