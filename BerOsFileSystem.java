/*
Problem Name : 20-A BerOS file system.
Problem Link : https://codeforces.com/contest/20/problem/A

My Approach : First, I check if the length of the string is 1, then I print the string and return. 
If the length of the string is greater than 1, I traverse the string from index 1. 
If the current character and the previous character are both '/', 
I continue the loop to skip duplicate slashes. Otherwise,
I add the previous character (i - 1) into another string ans. After the traversal, 
I check the last character of the input string. If the string is filled only with '/', 
I return a single slash "/". Otherwise, if the last character is not '/', I add it to ans and print the final result.

*/

import java.util.Scanner;
 
public class BerOsFileSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String ans = "";
        if (input.length() == 1) {
            System.out.println(input);
            return;
        }
        boolean ok = true;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == '/' && input.charAt(i - 1) == '/') {
                continue;
            }
            ok = false;
            ans = ans + input.charAt(i - 1);
        }
        if (input.charAt(input.length() - 1) == '/') {
            if (ok) {
                System.out.println("/");
                return;
            }
            System.out.println(ans);
        } else {
            ans = ans + input.charAt(input.length() - 1);
            System.out.println(ans);
        }
    }
}
