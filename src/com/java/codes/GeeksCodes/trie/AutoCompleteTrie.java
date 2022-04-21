package com.java.codes.GeeksCodes.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutoCompleteTrie {
    private class Node{
        String prefix;
        HashMap<Character,Node> children;
        boolean isWord;
        public Node(String prefix){
            this.prefix = prefix;
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
    private Node trie;
    public AutoCompleteTrie(String dict[]){
        trie = new Node("");
        for(String str : dict)
            createDictionary(str);
    }
    private void createDictionary(String str){
        Node curr = trie;
        for(int i=0;i<str.length();i++){
            if(!curr.children.containsKey(str.charAt(i))){
                curr.children.put(str.charAt(i), new Node(str.substring(0,i+1)));
            }
            curr = curr.children.get(str.charAt(i));
            if( i == str.length()-1)
                curr.isWord = true;
        }
    }
    private void findAllChildWords(Node curr, List<String> results){
        if(curr.isWord == true) results.add(curr.prefix);
        for(Character ch : curr.children.keySet())
            findAllChildWords(curr.children.get(ch), results);
    }
    public List<String> printAutoSuggestion(String prefix){
        Node curr= trie;
        List<String> results = new ArrayList<>();
        for(char ch : prefix.toCharArray()){
            if(!curr.children.containsKey(ch))
                return results;
            curr = curr.children.get(ch);
        }
        findAllChildWords(curr, results);
        return results;
    }
}
/*
String dict[] = {"abc", "ab", "bcd"};
        String prefix = "a";
        List<String> results;
        AutoCompleteTrie autoCompleteTrie = new AutoCompleteTrie(dict);
        results = autoCompleteTrie.printAutoSuggestion(prefix);
        Iterator<String> it = results.listIterator();
        while(it.hasNext())
            System.out.println(it.next());
 */