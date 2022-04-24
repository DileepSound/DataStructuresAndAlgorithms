package com.saveforgreen.datastructures.pattern.p4.mergeintervals;

import java.util.*;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public String toString() {
    return "["+start+"," +end+ "]";
  }
};

class MergeIntervals {

  public static List<Interval> merge(List<Interval> intervals) {
    List<Interval> mergedIntervals = new LinkedList<Interval>();
    // TODO: Write your code here
    //1. Sort the intervals by start value
    Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
    int currentIdx = 1;
    Interval a = intervals.get(0);
    int start = a.start;
    int end = a.end;
    while (currentIdx < intervals.size()) {
      Interval b = intervals.get(currentIdx);
      // there is a overlap
      if (b.start < end) {
        end = Math.max(end, b.end);
      } else {
        mergedIntervals.add(new Interval(start, end));
        start = b.start;
        end = b.end;
      }
      currentIdx++;
    }
   // add the last interval
   mergedIntervals.add(new Interval(start, end));

    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 5));
    input.add(new Interval(7, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print(interval);
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(6, 7));
    input.add(new Interval(2, 4));
    input.add(new Interval(5, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print(interval);
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 6));
    input.add(new Interval(3, 5));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print(interval);
    System.out.println();
  }
}
