/*
Problem Name : 2007-B Index and Maximum Value
Problem Link : https://codeforces.com/problemset/problem/2007/B

My Approach : In this question, we need to find the maximum value. 
When I took the array as input from the user, I also found the maximum element at the same time. 
The maximum value is checked within the range of l and r. 
Based on that, apply the operations + and -. Print maximum value after this operations.

*/
import java.util.*;

public class IndexAndMaximumValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt(); // length of array
            int m = input.nextInt(); // no of operations
            int[] a = new int[n];
            int currentMax = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
                if (a[i] > currentMax) {
                    currentMax = a[i];
                }
            }
            input.nextLine();
            ArrayList<Integer> list = new ArrayList<>();
            while (m-- > 0) {
                String str = input.nextLine();
                boolean posNeg;
                if (str.charAt(0) == '+') {
                    posNeg = true;
                } else {
                    posNeg = false;
                }
                int l = 0;
                int r = 0;
                boolean space = false;
                for (int i = 2; i < str.length(); i++) {
                    if (str.charAt(i) == ' ') {
                        space = true;
                        continue;
                    }
                    if (space == false) {
                        l = l * 10 + (str.charAt(i) - '0');
                    } else {
                        r = r * 10 + (str.charAt(i) - '0');
                    }
                }
                if (l <= currentMax && currentMax <= r) {
                    if (posNeg == true) {
                        currentMax = currentMax + 1;
                    } else {
                        currentMax = currentMax - 1;
                    }
                }
                list.add(currentMax);
            }
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
