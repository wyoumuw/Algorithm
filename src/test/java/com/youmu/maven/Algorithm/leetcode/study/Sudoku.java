package com.youmu.maven.Algorithm.leetcode.study;

import org.junit.Test;

public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] colums = new int[9][9];
        int[][] boxs = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < rows.length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int v = c - '0' - 1;
                    int box = j / 3 + i / 3 * 3;
                    if (rows[i][v] == 1 || colums[j][v] == 1 || boxs[box][v] == 1) {
                        return false;
                    }
                    rows[i][v] = colums[j][v] = boxs[box][v] = 1;
                }
            }
        }
        return true;
    }

    @Test
    public void Test() throws Exception {
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }
}
