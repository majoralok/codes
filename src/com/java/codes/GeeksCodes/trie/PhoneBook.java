package com.java.codes.GeeksCodes.trie;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    static class TrieNode {
        HashMap<Character, TrieNode> child;
        boolean isLast;

        public TrieNode() {
            child = new HashMap<>();
            for (char i = 'a'; i <= 'z'; i++)
                child.put(i, null);
            isLast = false;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            int len = s.length();
            TrieNode node = root;
            for (int i = 0; i < len; i++) {
                TrieNode nextNode = node.child.get(s.charAt(i));
                if (nextNode == null) {
                    nextNode = new TrieNode();
                    node.child.put(s.charAt(i), nextNode);
                }
                node = nextNode;
                if (i == len - 1)
                    node.isLast = true;
            }
        }

        private void displayContactsUtil(TrieNode curNode, String prefix, ArrayList<String> contactsWithPrefix) {
            if (curNode.isLast) {
                contactsWithPrefix.add(prefix);
            }
            for (char i = 'a'; i <= 'z'; i++) {
                TrieNode nextNode = curNode.child.get(i);
                if (nextNode != null) {
                    displayContactsUtil(nextNode, prefix + i, contactsWithPrefix);
                }
            }
        }

        public void getContacts(String str, HashMap<String, Integer> phonebook) {
            TrieNode prevNode = root;
            String prefix = "";
            int len = str.length(), i;
            for (i = 0; i < len; i++) {
                prefix += str.charAt(i);
                TrieNode curNode = prevNode.child.get(prefix.charAt(i));
                if (curNode == null) {
                    break;
                }
                ArrayList<String> contactsWithPrefix = new ArrayList<>();
                displayContactsUtil(curNode, prefix, contactsWithPrefix);
                contactsWithPrefix.forEach(contact -> System.out.println("Contact Name " + contact + " PhoneNumber is" + phonebook.get(contact)));
                prevNode = curNode;
            }
        }
    }

    static class PhoneBookDirectory {
        HashMap<String, Integer> phonebook;
        Trie trie;

        public PhoneBookDirectory() {
            phonebook = new HashMap<>();
            trie = new Trie();
        }

        public void addContact(String name, Integer phoneno) {
            phonebook.put(name, phoneno);
            trie.insert(name);
        }

        public void searchAndShowNoForAllCombination(String query) {
            trie.getContacts(query, phonebook);
        }
    }

    public static void main(String[] args) {
        PhoneBookDirectory directory = new PhoneBookDirectory();
        directory.addContact("gforgeeks", 1234);
        directory.addContact("geeksquiz", 4567);
        directory.addContact("Ricky", 134242444);
        directory.addContact("Peter", 224323423);
        directory.addContact("Ron", 988232323);
        String query = "g";
        directory.searchAndShowNoForAllCombination(query);
    }
}
