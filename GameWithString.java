/* 
Problem Name : 1104-B Game With String
Problem Link : https://codeforces.com/contest/1104/problem/B

My Approach : Repeatedly remove adjacent equal characters using StringBuilder and count moves. 
If total removals are odd print "Yes", otherwise print "No".
*/

import java.util.Scanner;
 
public class GameWithString {
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.next());
        int count = 0;
        for (int i = 0; i < sb.length() - 1;) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
 
                sb.delete(i, i + 2);
                count++;
 
                if (i > 0) {
                    i--;
                }
 
            } else {
                i++;
            }
        }
        if (count % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
