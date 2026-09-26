/*
Problem Name : Range Minimum Query
Problem Link : https://codeforces.com/edu/course/3/lesson/18/1/practice/contest/619571/problem/A

My Approach : First, I calculated the block size s using √n. 
Then, I created an array b to store the minimum element of each block.
Next, I found the minimum element in every block and stored it in b.For each query,
I used a while loop to find the answer.If the current block was completely inside
the query range, I used the minimum value from b and skipped the whole block by moving 
l by s.Otherwise, I checked the current element, updated the answer, 
and moved l by 1.Finally, I printed the minimum element for each query.

*/

import java.util.Scanner;
 
public class RangeMinimumQuery {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int s = (int) Math.sqrt(n);
            int blocks = (n + s - 1) / s;
            int[] b = new int[blocks];
            
            
            for(int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
 
            for(int i = 0; i < n; i += s) {
                int mn = Integer.MAX_VALUE;
                for(int j = i; j < Math.min(i + s, n); j++) {
                    mn = Math.min(mn, a[j]);
                }
                b[i / s] = mn;
            }
 
            int q = sc.nextInt();
 
            while (q-- > 0) {
                int l = sc.nextInt();
                int r = sc.nextInt();
 
                r++;
 
                int ans = Integer.MAX_VALUE;
                while (l < r) {
                    if(l % s == 0 && l + s <= r) {
                        ans = Math.min(ans, b[l / s]);
                        l += s;
                    } else {
                        ans = Math.min(ans, a[l]);
                        l++;
                    }
                }
 
                System.out.println(ans);
 
            } 
        }
    }
}
