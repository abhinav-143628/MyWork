package com.abhi.java.ProblemSolving;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by abhdogra1 on 1/16/2019.
 */
public class MatrixFindPath {
    static class StrAnswer {
        String direction = "";
    }

    static class StrPosition {
        int pos = 1;
    }


    public static void main(String[] args) {
        String[][] matrix = {
                {"a","b","j","f"},
                {"n","j","k","m"},
                {"e","f","q","z"}
        };
        String path = "abjfqz";
        //System.out.println(printPathTwoSideTraversal(matrix,path));
        MatrixFindPath obj = new MatrixFindPath();
        StrAnswer objStrAnswer = new StrAnswer();
        findPath(matrix,path,new StrPosition(),0,0, "", objStrAnswer);
        System.out.println(objStrAnswer.direction);
    }
    static class Node{
        int row;
        int col;
        String value;
        String direction;
        public Node(int row, int col, String val, String direction) {
            this.row = row;
            this.col = col;
            this.value = val;
            this.direction = direction;
        }
    }

    private static String printPathTwoSideTraversal(String[][] matrix, String path) {
        char[] arr = path.toCharArray();
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<String> queue = new LinkedList<>();
        Stack<Node> holder = new Stack<>();
        Queue<String> list = new LinkedList<>();

        for(char a: arr)
            queue.add(String.valueOf(a));

        holder.add(new Node(0,0,matrix[0][0],""));
        while(!holder.isEmpty()) {
            Node node = holder.pop();
            System.out.println(node.value+" - path value:- "+queue.peek());
            String val = matrix[node.row][node.col];
            if(val.equals(queue.peek())) {
                if (!node.direction.equalsIgnoreCase("")) {
                    list.add(node.direction);
                }
                queue.poll();

                if (node.row >= 0 && node.row + 1 < matrix.length ){
                    if(matrix[node.row+1][node.col].equals(queue.peek()))
                        holder.add(new Node(node.row+1, node.col, matrix[node.row+1][node.col], "D"));
                }
                if(node.col >= 0 && node.col + 1 < matrix[0].length) {
                    if(matrix[node.row][node.col+1].equals(queue.peek()))
                        holder.add(new Node(node.row, node.col + 1, matrix[node.row][node.col + 1], "R"));
                }
            }
        }
        return String.valueOf(list);
    }

    private static boolean findPath(String[][] matrix, String path, StrPosition i, int row, int column, String travel, StrAnswer objStrAnwer) {
        boolean isFuturePathAvaliable = false;
        if(i.pos==path.length()){
            objStrAnwer.direction = travel;
            return true;
        }
        if(row >= 0 && row + 1 < matrix.length && column >= 0 && column < matrix[0].length && matrix[row + 1][column].equals(String.valueOf(path.charAt(i.pos)))) {
            i.pos++;
            isFuturePathAvaliable = findPath(matrix, path, i, row + 1, column, travel + "D", objStrAnwer);
        }

        if(isFuturePathAvaliable== false && row >= 0 && row < matrix.length && column + 1 >= 0 && column + 1 < matrix[0].length && matrix[row][column + 1].equals(String.valueOf(path.charAt(i.pos)))) {
            i.pos++;
            isFuturePathAvaliable = findPath(matrix, path, i, row, column + 1, travel + "R", objStrAnwer);
        }
        if(isFuturePathAvaliable == false) {
            --i.pos;
        }
        return isFuturePathAvaliable;
    }

}
