/*
Problem Name : 2206-K Time Display Stickers
Problem Link : https://codeforces.com/contest/2206/problem/K

My Approach: First, I create an array of size 10. I convert each character into an integer
and use it as an index to count the digits. Then, I create four integers: st, lt, mid and ans.
After that, I start a while loop and check the condition arr[st] != 0 && st < 2.
Then, I calculate the hours and minutes and increment ans whenever a valid time can be formed.

*/

import java.util.Scanner;
 
public class Sol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
 
            int[] arr = new int[10];
            for (int i = 0; i < n; i++) {
                char ch = str.charAt(i);
                int num = ch - '0';
                arr[num]++;
            }
 
            int st = 0;
            int lt = 9;
            int mid = 5;
            int ans = 0;
            
            while (st <= lt) {
 
                if (arr[st] != 0 && st < 2) {
                    arr[st]--;
                    
                    if (st == 0) {
                        boolean hour = false;
                        for (int j = lt; j >= 0; j--) {
                            if (arr[j] != 0) {
                                arr[j]--;
                                lt = j;
                                hour = true;
                                break;
                            }
                        }
                        if (!hour) {
                        break;
                    }
                    } else {
                        if(arr[st] != 0) {
                            arr[st]--;
                        } else {
                            break;
                        }
                    }
                    
 
                    // minutes calculate
                    boolean minuteFirstDigit = false;
                    for (int i = mid; i >= 0; i--) {
                        if (arr[i] != 0) {
                            arr[i]--;
                            mid = i;
                            minuteFirstDigit = true;
                            break;
                        }
                    }
 
                    if (!minuteFirstDigit) {
                        break;
                    }
 
                    boolean minuteSecondDigit = false;
                    for (int i = lt; i >= 0; i--) {
                        if (arr[i] != 0) {
                            arr[i]--;
                            lt = i;
                            minuteSecondDigit = true;
                            break;
                        }
                    }
 
                    if (!minuteSecondDigit) {
                        break;
                    } else {
                        ans++;
                    }
                } else {
                    st++;
                }
            }
 
            System.out.println(ans);
        }
    }
}
