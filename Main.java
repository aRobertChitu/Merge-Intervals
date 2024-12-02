package com.robert;


import java.util.Arrays;
import java.util.Comparator;



public class Main {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int mergedIntervals = 0;
        for(int i = 0; i < intervals.length; i++){
            int k = i+1;
            while(k < intervals.length && intervals[i][1] >= intervals[k][0] ) {
                intervals[i][1] = max(intervals[k][1], intervals[i][1]);
                mergedIntervals++;
                intervals[k][0] = -1;
                k++;
            }
            i = k-1;
        }

        int[][] response = new int[intervals.length-mergedIntervals][2];
        int k = 0;

        for(int i = 0; i < intervals.length; i++){

            if(intervals[i][0]!= -1){
                response[k][0] = intervals[i][0];
                response[k][1] = intervals[i][1];
                k++;
            }
        }
        return response;

    }

    public static int max(int a, int b){
        if(a>b){
            return a;
        }else{
            return b;
        }
    }


}