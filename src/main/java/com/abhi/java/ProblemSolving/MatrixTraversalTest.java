package com.abhi.java.ProblemSolving;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by abhdogra1 on 1/21/2019.
 */
public class MatrixTraversalTest {

    public static void main(String[] args) {
        String[][] matrix = { { "a", "b", "j", "f" }, { "n", "j", "k", "m" }, { "e", "f", "q", "z" } };
        String path = "abjfqz";
        System.out.println(printPathTwoSideTraversal(matrix, path));

//        System.out.println("by recurssion and backtrracking");
//        MatrixFindPath.StrAnswer objStrAnswer = new MatrixFindPath.StrAnswer();
//        findPath(matrix, path, new MatrixFindPath.StrPosition(), 0, 0, "", objStrAnswer);
//        System.out.println(objStrAnswer.direction);
    }

    static class MatrixNode{
        int col;
        int row;
        String value;
        String path;
        public MatrixNode(int col, int row, String value,String path){
            this.col = col;
            this.row = row;
            this.value = value;
            this.path = path;
        }
    }

    private static String printPathTwoSideTraversal(String[][] matrix, String path) {
        Queue<MatrixNode> holder = new LinkedList<>();

        int col = 0, row = 0;
        String val = matrix[row][col];
        int i = 0;
        if(!val.equals(String.valueOf(path.charAt(i++))))
            return "";

        MatrixNode node1 = new MatrixNode(col,row,val,"");
        holder.add(node1);
        String retVal = "";
        while(holder.size() > 0){
            if(i > path.length()){
                break;
            }
            MatrixNode node = holder.poll();
            if(node.row < matrix.length && node.col+1 < matrix[0].length &&  matrix[node.row][node.col+1].equals(String.valueOf(path.charAt(i)))){
                node.path+="R";
                holder.add(new MatrixNode(row,col+1,matrix[node.row][node.col+1],node.path));
            }
            if(node.row+1 < matrix.length && node.col < matrix[0].length &&  matrix[node.row+1][node.col].equals(String.valueOf(path.charAt(i)))){
                node.path+="D";
                holder.add(new MatrixNode(row,col+1,matrix[node.row+1][node.col],node.path));
            }
            retVal = node.path;
            i++;
        }
        return retVal;
    }

}
