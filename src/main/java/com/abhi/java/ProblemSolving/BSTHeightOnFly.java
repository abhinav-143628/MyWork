package com.abhi.java.ProblemSolving;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhdogra1 on 1/10/2019.
 */
public class BSTHeightOnFly {

    class Node{
        int height;
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.height = 0;
            this.left = this.right = null;
        }
    }
    Node head;
    public void insert(int data){

        head=insertNode(this.head, data,new ArrayList<Node>());
        head=insertNode1(this.head, data,null, false);
    }


    public void delete(int data){

       delete(head,data);
    }

    private Node delete(Node head, int data) {
        if(head.data == data){
            return head;
        }

        if(head.data > data){
            head.right = delete(head.right,data);
        } else if(head.data < data){
            head.left = delete(head.left,data);
        }

       // if(head.left)
    }

    // Extra space
    private Node insertNode(Node head, int data, List<Node> ls) {

        if(head == null){
            if(ls.size() !=0 && ls.get(ls.size()-1).left == null && ls.get(ls.size()-1).right == null ){
                for(Node n : ls){
                    n.height++;
                }
            }
            head = new Node(data);
        }

        if(data > head.data){
            ls.add(head);
            head.right = insertNode(head.right,data,ls);
        }else if( data < head.data){
            ls.add(head);
            head.left = insertNode(head.left,data,ls);
        }

        System.out.println("height is: "+ head.height);
        return head;
    }

    //No extra space
    private Node insertNode1(Node head, int data, Node prev, boolean flag) {
        if(head == null){
            if(prev.right == null && prev.left == null)
                flag = true;
            head = new Node(data);
        }

        prev = head;
        if(data > head.data){
            head.right = insertNode1(head.right,data, prev,flag);
        }else if( data < head.data){
            head.left = insertNode1(head.left,data,prev,flag);
        }

        if(flag){
            head.height++;
        }

        System.out.println("height is 2: "+ head.height);
        return head;
    }

    public void printTree(){
        printTree(head);
    }

    private void printTree(Node head){
        if(head == null)
            return;

        printTree(head.left);
        System.out.println(head.data);
        printTree(head.right);
    }

    public static void main(String[] args) {
        BSTHeightOnFly obj = new BSTHeightOnFly();
        obj.insert(9);
        obj.insert(1);
        obj.insert(10);
        obj.insert(8);
        obj.insert(7);
        obj.insert(90);
        obj.insert(40);
        obj.insert(80);
        obj.insert(20);

        obj.printTree();


    }
}
