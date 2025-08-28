package com.corejava.mergSorTinMultithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer>listToSort ;
    ExecutorService executorService;
    public MergeSorter(List<Integer>listToSort,ExecutorService executorService){
        this.listToSort = listToSort;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception {
        int n = listToSort.size();
        if(n<=1) return listToSort;
        int mid = n/2;
        List<Integer> leftHalfList = new ArrayList<>();
        for(int i=0;i<mid;i++){
            leftHalfList.add(listToSort.get(i));
        }
        ArrayList<Integer> rightHalfList = new ArrayList<>();
        for(int i=mid;i<n;i++){
            rightHalfList.add(listToSort.get(i));
        }
//        ExecutorService executorService = Executors.newCachedThreadPool(); // more optimsation .
        MergeSorter leftHalfSorter = new MergeSorter(leftHalfList,executorService);
        MergeSorter rightHalfSorter = new MergeSorter(rightHalfList,executorService);

        // pass the task to the threads by using executor service
        Future<List<Integer>> leftHalfSotedFuture = executorService.submit(leftHalfSorter);
        Future<List<Integer>> rightHalfSortedFuture = executorService.submit(rightHalfSorter);

        // merge in new List.

        List<Integer> leftHalfSortedArray = leftHalfSotedFuture.get(); // blocking calls
        List<Integer> rightHalfSortedArray = rightHalfSortedFuture.get();// blocking calls
        List<Integer> sortedArray = new ArrayList<>();
        // merge the leftHalfArray and rightHalfArray into sortedArray
        int i=0;
        int j =0;
        while(i<leftHalfSortedArray.size() && j<rightHalfSortedArray.size()){
            if(leftHalfSortedArray.get(i)<rightHalfSortedArray.get(j)){
                sortedArray.add(leftHalfSortedArray.get(i));
                i++;
            }else{
                sortedArray.add(rightHalfSortedArray.get(j));
                j++;
            }
        }
        while(i<leftHalfSortedArray.size()){
            sortedArray.add(leftHalfSortedArray.get(i));
            i++;
        }
        while(j<rightHalfSortedArray.size()){
            sortedArray.add(rightHalfSortedArray.get(j));
            j++;
        }

        return sortedArray;
    }

}
