package com.abhi.java.ProblemSolving;

import java.util.LinkedList;
import java.util.Queue;

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
        String[][] matrix = { { "a", "b", "j", "f" }, { "n", "j", "k", "m" }, { "e", "f", "q", "z" } };
        String path = "abjfqz";
        System.out.println(printPathTwoSideTraversal(matrix, path));

        System.out.println("by recurssion and backtrracking");
        StrAnswer objStrAnswer = new StrAnswer();
        findPath(matrix, path, new StrPosition(), 0, 0, "", objStrAnswer);
        System.out.println(objStrAnswer.direction);
    }

    static class Node {
        int row;
        int col;
        String value;
        String direction;
        int strPos;

        public Node(int row, int col, String val, String direction, int strPos) {
            this.row = row;
            this.col = col;
            this.value = val;
            this.direction = direction;
            this.strPos = strPos;
        }
    }

    private static String printPathTwoSideTraversal(String[][] matrix, String path) {
        Queue<Node> holder = new LinkedList<>();
        String retVal = "";

        holder.add(new Node(0, 0, matrix[0][0], "", 1));
        while (!holder.isEmpty()) {
            Node node = holder.poll();
            System.out.println(node.value + " - path value:- " + String.valueOf(path.charAt(node.strPos)));

            if (node.row >= 0 && node.row + 1 < matrix.length && node.col >= 0 && node.col < matrix[0].length
                    && matrix[node.row + 1][node.col].equals(String.valueOf(path.charAt(node.strPos)))) {
                holder.add(new Node(node.row + 1, node.col, matrix[node.row + 1][node.col], node.direction + "D",
                        node.strPos + 1));
                if (node.strPos == path.length() - 1) {
                    retVal = node.direction + "D";
                    break;
                }
            }
            if (node.row >= 0 && node.row < matrix.length && node.col + 1 >= 0 && node.col + 1 < matrix[0].length
                    && matrix[node.row][node.col + 1].equals(String.valueOf(path.charAt(node.strPos)))) {
                holder.add(new Node(node.row, node.col + 1, matrix[node.row][node.col + 1], node.direction + "R",
                        node.strPos + 1));
                if (node.strPos == path.length() - 1) {
                    retVal = node.direction + "R";
                    break;
                }
            }
        }
        return retVal;
    }

    private static boolean findPath(String[][] matrix, String path, StrPosition i, int row, int column, String travel,
                                    StrAnswer objStrAnwer) {
        boolean isFuturePathAvaliable = false;
        if (i.pos == path.length()) {
            objStrAnwer.direction = travel;
            return true;
        }
        if (row >= 0 && row + 1 < matrix.length && column >= 0 && column < matrix[0].length
                && matrix[row + 1][column].equals(String.valueOf(path.charAt(i.pos)))) {
            i.pos++;
            isFuturePathAvaliable = findPath(matrix, path, i, row + 1, column, travel + "D", objStrAnwer);
        }

        if (isFuturePathAvaliable == false && row >= 0 && row < matrix.length && column + 1 >= 0
                && column + 1 < matrix[0].length
                && matrix[row][column + 1].equals(String.valueOf(path.charAt(i.pos)))) {
            i.pos++;
            isFuturePathAvaliable = findPath(matrix, path, i, row, column + 1, travel + "R", objStrAnwer);
        }

        if (isFuturePathAvaliable == false) {
            --i.pos;
        }

        return isFuturePathAvaliable;
    }


}
