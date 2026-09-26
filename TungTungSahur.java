/*
Problem Name : 2094-D Tung Tung Sahur
Problem Link : https://codeforces.com/contest/2094/problem/D

My Approach : Firstly, I created a counter function that counts consecutive L or R characters. 
Then, I return the index and the count of the consecutive L or R characters.
In the main function, I started a while loop that compares the counts of L or R, 
and it keeps calling the counter function until the condition becomes false. Finally, I print YES or NO.

*/

 
import java.util.Scanner;
 
public class TungTungSahur {
    static int[] counter(String str, int idx) {
        char ch = str.charAt(idx);
        int[] arr = new int[2];
        int count = 1;
        int i;
        for (i = idx + 1; i < str.length(); i++) {
            if (ch == str.charAt(i)) {
                count++;
            } else {
                arr[0] = i;
                arr[1] = count;
                return arr;
            }
        }
        arr[0] = i;
        arr[1] = count;
        return arr;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        while (t-- > 0) {
            String s = sc.next();
            String p = sc.next();
            int sIdx = 0;
            int pIdx = 0;
            boolean ok = true;
            while (sIdx < s.length() && pIdx < p.length()) {
 
                char sChar = s.charAt(sIdx);
                int[] sArr = counter(s, sIdx);
                sIdx = sArr[0];
                int sCount = sArr[1];
            
                char pChar = p.charAt(pIdx);
                if (sChar == pChar) {
                    int[] pArr = counter(p, pIdx);
                    pIdx = pArr[0];
                    int pCount = pArr[1];

                    boolean idexIs = true;
                    if(sIdx == s.length() && pIdx != p.length() || sIdx != s.length() && pIdx == p.length()) {
                        idexIs = false;
                    }
                    if (pCount >= sCount && pCount <= sCount * 2 && sCount <= pCount &&  idexIs) {
                        continue;
                    } else {
                        ok = false;
                        break;
                    }
                } else {
                    ok = false;
                    break;
                }
 
            }
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

