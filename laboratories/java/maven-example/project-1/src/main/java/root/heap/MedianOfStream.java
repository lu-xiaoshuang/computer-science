/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/find-median-from-data-stream/
//
// 最大堆保存比中位数小的数，最小堆保存比中位数大的数
// 最大堆的大小等于最小堆的大小，或者最大堆的大小比最小堆的大小大一

public class MedianOfStream {
    private static class Comparator1 implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }

    private static class Comparator2 implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b.compareTo(a);
        }
    }

    private PriorityQueue<Integer> queueMax = new PriorityQueue<Integer>(new Comparator1());

    private PriorityQueue<Integer> queueMin = new PriorityQueue<Integer>(new Comparator2());

    public void add(int value) {
        queueMax.add(value);
        Integer temp = queueMax.poll();
        queueMin.add(temp);
        if (queueMax.size() < queueMin.size()) {
            temp = queueMin.poll();
            queueMax.add(temp);
        }
    }

    public double getMedian() {
        int a = queueMax.peek();
        if (queueMax.size() > queueMin.size()) {
            return a;
        }
        int b = queueMin.peek();
        return (a + b) / 2.0;
    }

    public static void main(String[] stringArray) {
        MedianOfStream medianOfStream = new MedianOfStream();
        int[] array = new int[] { 5, 2, 3, 4, 1, 6, 7, 0, 8 };
        for (int i = 0; i < array.length; ++ i) {
            medianOfStream.add(array[i]);
            double median = medianOfStream.getMedian();
            System.out.println(median);
        }
    }
}
