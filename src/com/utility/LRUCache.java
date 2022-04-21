package com.utility;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCache {

    private final int CACHE_SIZE;
    private Set<Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashSet();
        CACHE_SIZE = capacity;
    }
    public void refer(int page){
        if(get(page) == false)
            put(page);
    }
    public boolean get( int page){
        if(!cache.contains(page))
            return false;
        cache.remove(page);
        cache.add(page);
        return true;
    }
    public void put(int page){
        if(cache.contains(page)){
            cache.remove(page);
        } else{
            if(cache.size() == CACHE_SIZE){
                int last = cache.iterator().next();
                cache.remove(last);
            }
        }
        cache.add(page);
    }
    public void Display(){
        Iterator<Integer> it = cache.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
