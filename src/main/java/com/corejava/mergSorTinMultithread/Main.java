package com.corejava.mergSorTinMultithread;

import java.security.spec.EdECPrivateKeySpec;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> listToSort = List.of(4,1,2,5,3,2,6,7,4,53,4);

        ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSorter mergeSorter = new MergeSorter(listToSort,executorService);
        Future<List<Integer>> sorterdListFuture =  executorService.submit(mergeSorter);

        for(int num: sorterdListFuture.get()){
            System.out.print(num+" ");
        }
        return ;
    }
}
