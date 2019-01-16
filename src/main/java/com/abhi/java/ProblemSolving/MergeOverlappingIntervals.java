package com.abhi.java.ProblemSolving;

import java.util.*;

/**
 * Created by abhdogra1 on 1/11/2019.
 */
public class MergeOverlappingIntervals {
    static class Intervals{
        int first;
        int last;
        String abc;
        public Intervals(int first, int last){
            this.first = first;
            this.last = last;
        }

    }
    public static void main(String[] args) {
        List<Intervals> ls = new ArrayList<>();

        ls.add(new Intervals(1,4));
        ls.add(new Intervals(2,6));
        ls.add(new Intervals(7,10));
        ls.add(new Intervals(9,14));
        ls.add(new Intervals(14,19));

        List<Intervals> ret = mergeIntervals(ls);
        for(Intervals i : ret){
            System.out.println("First: "+i.first+" Second: "+ i.last);
        }

    }

    private static List<Intervals> mergeIntervals(List<Intervals> ls) {
        List<Intervals> retls = new ArrayList<>();
        Stack<Integer> holder = new Stack<>();

        for(Intervals i : ls){
            int lastInterval;
            if(holder.size() != 0){
                lastInterval = holder.peek();
                if(i.first <= lastInterval){
                    holder.pop();
                    holder.add(i.last);
                }else{
                    holder.add(i.first);
                    holder.add(i.last);
                }
            }else{
                holder.add(i.first);
                holder.add(i.last);
            }
        }

        for(int i = 0; i< holder.size()-1;i++){
            retls.add(new Intervals(holder.get(i),holder.get(i+1)));
            i++;
        }

        return retls;
    }
}
