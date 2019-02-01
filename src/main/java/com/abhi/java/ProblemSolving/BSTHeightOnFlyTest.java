package com.abhi.java.ProblemSolving;

import java.util.ArrayList;

/**
 * Created by abhdogra1 on 1/21/2019.
 */
public class BSTHeightOnFlyTest {

    class NodeTest{
        NodeTest left;
        NodeTest right;
        int data;
        int height;
        public NodeTest(int data){
            this.data = data;
            right = left = null;
            this.height = 0;
        }
    }

    NodeTest head = null;
    NodeTest head1 = null;

    public static void main(String[] args) {
        BSTHeightOnFlyTest obj = new BSTHeightOnFlyTest();
        obj.insert(9);
        obj.insert(1);
        obj.insert(10);
        obj.insert(8);
        obj.insert(7);
        obj.insert(90);
        obj.insert(40);
        obj.insert(80);
        obj.insert(20);
        obj.insert(95);
        obj.insert(85);
        obj.insert(92);
        obj.insert(105);

        System.out.println("tree before deletion");
        obj.printTree();

        obj.delete(40);
        obj.delete(90);

        System.out.println("tree after deletion");

        obj.printTree();
    }

    private void printTree() {
        if(head1 == null)
            return;
        printTreeVal(this.head1);
    }

    private void printTreeVal(NodeTest node) {
        if(node == null)
            return;
        printTreeVal(node.left);
        System.out.println(node.data);
        printTreeVal(node.right);

    }

    private void insert(int data) {
      //  head = insertNode(head,data,null,false);
        this.head1 = insertNodeSpace(this.head1,data,new ArrayList<NodeTest>());
    }

    private NodeTest insertNodeSpace(NodeTest head1, int data, ArrayList<NodeTest> nodeTests) {
        if(head1 == null){
            if(nodeTests.size() != 0 && nodeTests.get(nodeTests.size()-1).right == null && nodeTests.get(nodeTests.size()-1).left == null){
                for(NodeTest node : nodeTests){
                    node.height++;
                }
            }
            head1 = new NodeTest(data);
        }

        if(data > head1.data){
            nodeTests.add(head1);
            head1.right = insertNodeSpace(head1.right,data, nodeTests);
        }else if(data < head1.data){
            nodeTests.add(head1);
            head1.left = insertNodeSpace(head1.left,data,nodeTests);
        }
        System.out.println("height2 "+head1.height);
        return head1;
    }


    private NodeTest insertNode(NodeTest head, int data,NodeTest prev, boolean flag) {
        if(head == null){
            if(prev!= null && prev.left == null && prev.right == null){
                flag = false;
            }
            head = new NodeTest(data);
        }
        prev = head;
        if(data > head.data){
            head.right = insertNode(head.right,data, prev,true);
        }else if(data < head.data){
            head.left = insertNode(head.left,data,prev,true);
        }
        if(flag)
           head.height++;

        System.out.println("height "+head.height);
        return head;
    }

    private void delete(int data) {
        deleteNode(this.head1,data);
    }

    private NodeTest deleteNode(NodeTest head, int data) {
        if(head == null){
            return head;
        }

        if(data > head.data){
            head.right = deleteNode(head.right,data);
        }else if(data < head.data){
            head.left = deleteNode(head.left,data);
        }else{
            if(head.right == null){
                return head.left;
            }else if(head.left == null){
                return head.right;
            }
            head.data = minValue(head.right);
            head.right = deleteNode(head.right,head.data);
        }

        return head;
    }

    private int minValue(NodeTest right) {
        int minVal = right.data;

        while(right.left != null){
            minVal = right.left.data;
            right = right.left;
        }
        return minVal;
    }
}
