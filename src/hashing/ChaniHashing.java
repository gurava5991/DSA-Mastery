package hashing;

import java.util.LinkedList;

public class ChaniHashing {
    int BUCKET = 10;
    LinkedList<Integer>[] tables;
    public ChaniHashing(int BUCKET) {
        tables = new LinkedList[BUCKET];
        for (int i = 0; i < BUCKET; i++) {
            tables[i] = new LinkedList<>();
        }
    }
    public static void main(String[] args) {
        ChaniHashing h = new ChaniHashing(10);
        int[] a = {15, 11, 27, 8, 12};
        int n = a.length;



        // Insert keys into the hash table
        for (int i = 0; i < n; i++) {
            h.insertItem(a[i]);
        }

        // Delete 12 from the hash table
        h.deleteItem(12);

        // Display the hash table
        h.displayHash();
    }

    private void displayHash() {
        for (int i = 0; i < BUCKET; i++) {
            System.out.println("table[" + i + "]: " + tables[i]);
        }
    }

    private void deleteItem(int key) {
        int index = key % BUCKET;

        // Check if the key exists and remove it
        if (tables[index].contains(key)) {
            tables[index].remove(Integer.valueOf(key));
        }

    }

    private void insertItem(int i) {
        int hash = i % BUCKET;
        tables[hash].add(i);

    }
}
