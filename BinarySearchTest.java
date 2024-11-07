package com.firstproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private BinarySearch bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearch();
    }

    @Test
    void testInsert() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        
        // Checking if inserted elements exist in BST
        assertTrue(bst.search(50));
        assertTrue(bst.search(30));
        assertTrue(bst.search(70));
        assertFalse(bst.search(100)); // 100 is not inserted
    }

    @Test
    void testSearch() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        
        assertTrue(bst.search(50)); // Check if 50 exists
        assertTrue(bst.search(30)); // Check if 30 exists
        assertFalse(bst.search(90)); // 90 doesn't exist
    }

    // Add more test methods as needed...
}
