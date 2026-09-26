/*
Problem Name : 45-I TCMCF+++
Problem Link : https://codeforces.com/contest/45/problem/I

My Approach : First, I store positive numbers in the ans list and negative numbers 
store in NegEl list and Zeroes in the ZeroEl list.
Then, I sort the NegEl list and store all NegEl list numbers in ans list when 
the size of NegEL List is even Otherwise, I skip the last element. Finally, I print the ans.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
public class TCMCF+++ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        List<Integer> NegEl = new ArrayList<>();
        List<Integer> ZeroEl = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(num > 0) {
                ans.add(num);
            } else if (num < 0) {
                NegEl.add(num);
            } else {
                ZeroEl.add(num);
            }
        }

        if(ans.isEmpty() && NegEl.isEmpty()) {
            System.out.print("0");
            return;
        }

        Collections.sort(NegEl);
        int size = NegEl.size();

        if(NegEl.size() % 2 != 0) {
            size = NegEl.size() - 1;
            if(ans.isEmpty() && NegEl.size() == 1 && ZeroEl.size() > 0) {
                System.out.print("0");
                return;
            } else if (ans.isEmpty() && NegEl.size() == 1 && ZeroEl.isEmpty()) {
                System.out.print(NegEl.get(0));
                return;
            }
        }

        for(int i = 0; i < size; i++) {
            ans.add(NegEl.get(i));
        }

        for(int x: ans) {
            System.out.print(x + " ");
        }
    }
}
