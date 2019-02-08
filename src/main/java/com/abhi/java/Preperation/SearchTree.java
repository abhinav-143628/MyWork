package com.abhi.java.Preperation;

import org.junit.Test;
import org.junit.runner.JUnitCore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by abhdogra1 on 2/8/2019.
 */
public class SearchTree {
    static class BST {

        private Node root;

        public BST() {
            this.root = new Node();
        }

        public void put(int value) {

            buildTree(root, value);
        }

        private void buildTree(Node root, int value) {
            if (root.val == null) {
                root.val = value;
            }

            if (value > root.val) {
                if (root.right == null)
                    root.right = new Node();
                buildTree(root.right, value);
            } else if (value < root.val) {
                if (root.left == null)
                    root.left = new Node();
                buildTree(root.left, value);
            }

        }

        public boolean contains(int value) {

            return contains(root, value);
        }

        private boolean contains(Node root, int value) {
            if (root == null || root.val == null)
                return false;
            else {
                if (value == root.val)
                    return true;
                else if (value > root.val) {
                    return contains(root.right, value);
                } else if (value < root.val)
                    return contains(root.left, value);
            }

            return false;
        }

        public List<Integer> inOrderTraversal() {
            final ArrayList<Integer> acc = new ArrayList<>();
            inOrderTraversal(root, acc);
            return acc;
        }

        private void inOrderTraversal(Node node, List<Integer> acc) {
            if (node == null || node.val == null) {
                return;
            }
            inOrderTraversal(node.left, acc);
            // this change
            acc.add(node.val);
            inOrderTraversal(node.right, acc);

        }

        private static class Node {
            Integer val;
            Node left;
            Node right;
        }
    }

    @Test
    public void testBST() {
        final BST searchTree = new BST();

        searchTree.put(3);
        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(5);

        assertFalse(searchTree.contains(0));
        assertTrue(searchTree.contains(1));
        assertTrue(searchTree.contains(2));
        assertTrue(searchTree.contains(3));
        assertFalse(searchTree.contains(4));
        assertTrue(searchTree.contains(5));
        assertFalse(searchTree.contains(6));

        assertEquals(Arrays.asList(1, 2, 3, 5), searchTree.inOrderTraversal());
    }

    @Test
    public void testEmpty() {
        final BST searchTree = new BST();

        assertEquals(Arrays.asList(), searchTree.inOrderTraversal());
    }

    @Test
    public void testNegative() {
        final BST searchTree = new BST();

        searchTree.put(-1);
        searchTree.put(11);
        searchTree.put(-10);
        searchTree.put(50);

        assertEquals(Arrays.asList(-10, -1, 11, 50), searchTree.inOrderTraversal());
    }

    @Test
    public void testDupes() {
        final BST searchTree = new BST();

        searchTree.put(1);
        searchTree.put(2);
        searchTree.put(1);
        searchTree.put(2);

        assertEquals(Arrays.asList(1, 1, 2, 2), searchTree.inOrderTraversal());
    }

    public static void main(String[] args) {
        JUnitCore.main("SearchTree");
    }
}
