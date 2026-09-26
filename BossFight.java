/*
Problem Name : 2252-A Boss Fight
Problem Link : https://codeforces.com/contest/2252/problem/A

My Approach : First, I create a TreeMap, and all elements are added in descending order.
It stores elements in key-value pair. Then, I find the pair with the maximum value.
It is stored in the variables el and value. Then, I count the values and store them in a variable. 
I calcualte the total sum of all pairs, skipping only the maximum el and value pair. 
Finally , I calculate the result and print it.

*/

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class BossFight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                map.put(a, map.getOrDefault(a, 0) + 1);
            }

            int result = 0;
          //  int prev = -1;

          //  int i = 1;
            int el = 0;
            int value = 0;
            int largestValues = 0;

            int max = 0;
            for(int key : map.keySet()) {
                if(map.get(key) > max) {
                    max = map.get(key);
                    el = key;
                    value = max;
                }
            }

            for(int key: map.keySet()) {
                if(key == el && map.get(key) == value) {
                    continue;
                } 
                if(max != map.get(key)) {
                    largestValues += map.get(key);
                }

                int totalSum = key * map.get(key);
                
                result += totalSum;
                
            }


            if(map.size() > 1 && largestValues == 0) {
                largestValues = max;
            }

            if(largestValues == 0) {
                if(value >= 2) {
                    System.out.println(el * 2);
                } else {
                    System.out.println(el * 1);
                }
                continue;
            }


            if(value > largestValues) {
                if(value == largestValues + 1) {
                    result += el * value;
                } else {
                    result += el * (largestValues + 2);
                }
            } else if(value <= largestValues) {
                result += el * value;
            }

            System.out.println(result);
        }
    }
}
