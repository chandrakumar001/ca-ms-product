package com.chstore.ca.employee.jpa.envers;

import java.util.*;

public class Test {



    /*static int check(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("input must not be null/empty");
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        PriorityQueue pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry.getValue());
        }
        if (pq == null) {
            throw new RuntimeException("input must not be null/empty");
        }
        while (pq.size() != 0) {
            int most_frequent = pq.poll();
            if (pq.size() == 0) {
                return count;
            }

            if (most_frequent == pq.peek()) {
                if (most_frequent > 1) {
                    pq.add(most_frequent - 1);
                }
                count++;
            }
        }
        return count;

    }*/

    /*static int check(String input) {

        int i, j;
        int fr[] = new int[26];

        int n = input.length();
        for (i = 0; i < n; i++) {

            char x = input.charAt(i);
            fr[x - 'a'] += 1;
        }

        int minimum = Integer.MAX_VALUE;

        for (i = 0; i < 26; i++) {
            for (j = i + 1; j < 26; j++) {

                int z = fr[i] + fr[j];
                minimum = Math.min(minimum, n - z);
            }
        }
        return minimum;
    }*/


    public int solution(int[] input) {

        int size = input.length;
        Set<Integer> set = new HashSet<>();
        for (int a : input) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= size + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return size;
    }


    public int solution1(int[] input) {
        int minAvgIdx = 0;
        double minAvgVal = (input[0] + input[1]) / 2; //At least two elements in input.
        double currAvg;
        for (int i = 0; i < input.length - 2; i++) {
            /**
             * We check first the two-element slice
             */
            currAvg = ((double) (input[i] + input[i + 1])) / 2;
            if (currAvg < minAvgVal) {
                minAvgVal = currAvg;
                minAvgIdx = i;
            }
            /**
             * We check the three-element slice
             */
            currAvg = ((double) (input[i] + input[i + 1] + input[i + 2])) / 3;
            if (currAvg < minAvgVal) {
                minAvgVal = currAvg;
                minAvgIdx = i;
            }
        }
        currAvg = ((double) (input[input.length - 2] + input[input.length - 1])) / 2;
        if (currAvg < minAvgVal) {
            minAvgVal = currAvg;
            minAvgIdx = input.length - 2;
        }
        return minAvgIdx;
    }
}
