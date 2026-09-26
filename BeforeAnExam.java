/*
Problem Name : 4-B Before an Exam.
Problem Link : https://codeforces.com/contest/4/problem/B

My Approach : First, I create two arrays named min and max. 
Then, I initialize i and maxTotal to 0. Next, I take input values: 
the minimum time is stored in the min array and the maximum time is stored in the max array, 
and I also calculate the sum of max values using maxTotal. Then, I check if (sumTime > maxTotal). 
If this condition is true, I print NO. Otherwise, I subtract all min values from sumTime. 
Then, I check if (hours < 0). If it is true, I print NO. Next, if (hours == 0), 
I print YES and print the min array. Finally, if (hours != 0), 
I distribute the remaining hours among the min values without exceeding the max values and print the result.
*/

import java.util.Scanner;
 
public class BeforeAnExam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt(), sumTime = sc.nextInt();
        int[] min = new int[days];
        int[] max = new int[days];
        int i = 0;
        int maxTotal = 0;
        while (i < days) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            min[i] = a;
            max[i] = b;
            maxTotal += b;
            i++;
        }
 
        if (sumTime > maxTotal) {
            System.out.println("NO");
            return;
        }
 
        int hours = sumTime;
        for (int k : min) {
            hours -= k;
            if (hours < 0) {
                break;
            }
        }
 
        if (hours < 0) {
            System.out.println("NO");
        } else if (hours == 0) {
            System.out.println("YES");
            for (int k : min) {
                System.out.print(k + " ");
            }
            System.out.println();
        } else {
            System.out.println("YES");
            int j = 0;
            while (j < days) {
                int sub = max[j] - min[j];
                hours -= sub;
                if (hours < 0) {
                    hours += sub;
                    if (hours > 0) {
                        min[j] += hours;
                    }
                    break;
                }
                min[j] += sub;
                System.out.print(min[j] + " ");
                j++;
            }
 
            while (j < days) {
                System.out.print(min[j] + " ");
                j++;
            }
            System.out.println();
        }
 
    }
}
