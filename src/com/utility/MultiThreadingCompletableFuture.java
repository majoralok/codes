package com.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MultiThreadingCompletableFuture {
/*
The parallel stream by default uses ForkJoinPool.commonPool which has one less thread than number of processor/core.
processor and core is same, but generally cpu is called as processor rather then core
This means parallel stream uses all available processors/core because it uses the main thread as well.

In case, you are using multiple parallel streams, then they will share same ForkJoinPool.commonPool.
This means you may not be able to use all the processors assigned to each parallel stream.

int availableProcessors = Runtime.getRuntime().availableProcessors();

The Callable object returns Future object

System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
-Djava.util.concurrent.ForkJoinPool.common.parallelism=5
we do not use above approach because it limit the thread size for complete application

Advantage- Using the common pool normally reduces resource usage

its strongly recommended to avoid stateful operations when using parallel streams so as to remove any potential data side effects
 */
    /*
Instant start = Instant.now();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        //CompletableFuture<List> completableFuture1 = CompletableFuture.supplyAsync(() -> getListOfCount());
        //CompletableFuture<List> completableFuture2 = CompletableFuture.supplyAsync(() -> getListOfCount());
        list1 = getListOfCount();
        list2 = getListOfCount();
        sleepThread();
        /*try {
            list1 = completableFuture1.get();
            list2 = completableFuture2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println(list1.size());
        System.out.println(list2.size());
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));

     */
    /*
    public static List getListOfCount(){
        List<Integer> integerList = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<100;i++){
            integerList.add(i);
        }
        //integerList.parallelStream().forEach(x->list.add(getInt(x)));
        list = integerList.parallelStream().map(x->getInt(x)).collect(Collectors.toList());
        return list;
    }
     */
    /*
    public static List getListOfCount(){
        List<Integer> integerList = new ArrayList<>();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<100;i++){
            integerList.add(i);
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool(availableProcessors);
        Callable<List> callable = () -> integerList.parallelStream().map(x->getInt(x)).collect(Collectors.toList());
        try {
            list = forkJoinPool.submit(callable).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return list;
    }
     */
}
//Integer integer = CompletableFuture.supplyAsync(() -> getInt()).join();